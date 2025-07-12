package arrays;

/**
 * https://leetcode.com/problems/concatenation-of-array/description/
 */
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l * 2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % l];
        }

        return ans;
    }
}
