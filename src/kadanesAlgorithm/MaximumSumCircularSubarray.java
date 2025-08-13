package kadanesAlgorithm;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/description/
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int max = 0, maxSum = nums[0];
        int min = 0, minSum = nums[0];

        for (int num : nums) {
            max = Math.max(num, max + num);
            maxSum = Math.max(max, maxSum);

            min = Math.min(num, min + num);
            minSum = Math.min(min, minSum);

            total += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }
}
