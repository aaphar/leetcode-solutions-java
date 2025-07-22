package july;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value/description
 */
public class MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                set.add(nums[right]);
                right++;
            } else {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            maxSum = Math.max(sum, maxSum);

        }

        return maxSum;
    }

    public int maximumUniqueSubarrayArr(int[] nums) {
        boolean[] seen = new boolean[10001];
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (right < nums.length) {
            if (!seen[nums[right]]) {
                sum += nums[right];
                seen[nums[right]] = true;
                right++;
            } else {
                sum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
