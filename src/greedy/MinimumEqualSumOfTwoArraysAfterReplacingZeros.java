package greedy;

/**
 * https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/
 */
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zero1 = 0;
        long sum2 = 0;
        int zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                zero1++;
                sum1++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                zero2++;
                sum2++;
            }
        }

        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}
