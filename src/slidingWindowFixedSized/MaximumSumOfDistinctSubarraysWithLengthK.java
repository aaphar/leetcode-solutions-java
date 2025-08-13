package slidingWindowFixedSized;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 1, 1, 1, 1, 1}, 1));
    }

    public long maximumSubarraySumBetter(int[] nums, int k) {
        long ans = 0;
        long currentSum = 0;
        int begin = 0;
        int end = 0;

        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);
            // if current window already has number or if window is too big, adjust window
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin];
                begin++;
            }
            numToIndex.put(currNum, end);
            currentSum += nums[end];
            if (end - begin + 1 == k) {
                ans = Math.max(ans, currentSum);
            }
            end++;
        }
        return ans;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            int count = map.getOrDefault(nums[right], 0) + 1;
            map.put(nums[right], count);

            while (map.get(nums[right]) > 1) {
                sum -= nums[left];
                int c = map.get(nums[left]) == 1 ? 0 : map.get(nums[left]) - 1;
                map.put(nums[left], c);
                left++;
            }

            sum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[left];
                int c = map.get(nums[left]) == 1 ? 0 : map.get(nums[left]) - 1;
                map.put(nums[left], c);
                left++;
            }
            right++;
        }

        // nums = [1,5,4,2,9,9,9], k = 3

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
