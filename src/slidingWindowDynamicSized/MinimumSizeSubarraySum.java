package slidingWindowDynamicSized;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum
 */
public class MinimumSizeSubarraySum {

    // Time complexity: O(n)
    // Space complexity: O(1)

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int result = Integer.MAX_VALUE;

        for (right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];

            while (sumOfCurrentWindow >= target) {
                result = Math.min(result, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * You may be thinking: there is an inner while loop inside another for loop, isn't the time complexity O(n^2)?
     * The reason it is still O(n) is because the right pointer right can move n times and the left pointer
     * left can move also n times in total. The inner loop is not running n times for each iteration of the outer loop.
     * A sliding window guarantees a maximum of 2n window iterations. This is what is referred to as amortized analysis -
     * even though the worst case for an iteration inside the for loop is O(n), it averages out to O(1) when you consider
     * the entire runtime of the algorithm.
     */
}
