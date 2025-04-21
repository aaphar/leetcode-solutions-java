package math;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/
 */
public class MinimumOperationsToMakeArraySumDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
