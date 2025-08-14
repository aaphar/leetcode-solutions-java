package kadanesAlgorithm;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        maxProduct(new int[]{2, -5, -2, -4, 3});

    }

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            res = Math.max(res, n);
        }

        int curMax = 1, curMin = 1; // 2, -5   n=-5

        for (int n : nums) {
            int temp = curMax * n;
            curMax = Math.max(temp, Math.max(curMin * n, n));
            curMin = Math.min(temp, Math.min(curMin * n, n));

            res = Math.max(res, curMax);
        }

        return res;
    }
}
