package prefixSumPattern;

/**
 * https://leetcode.com/problems/find-pivot-index/
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int left = 0;

        while (left < length) {
            int sumLeft = left == 0 ? 0 : sum[left - 1];
            int sumRight = left == length - 1 ? 0 : sum[length - 1] - sum[left];
            if (sumLeft == sumRight) {
                return left;
            }
            left++;
        }
        return -1;
    }
}
