package prefixSumPattern;

/**
 * 303. Range Sum Query - Immutable
 * <p>
 * https://leetcode.com/problems/range-sum-query-immutable/
 * </p>
 */
public class NumArray {

    private int[] prefixSums;

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    }

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSums[right];
        }
        return prefixSums[right] - prefixSums[left - 1];
    }
}


/**
 *
 * explanationWithImages/prefixSum.png
 *
 * Input
 * ["prefixSumPattern.NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 * <p>
 * <p>
 * <p>
 * Explanation
 * prefixSumPattern.NumArray numArray = new prefixSumPattern.NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */