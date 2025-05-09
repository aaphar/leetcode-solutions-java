package arrays;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/build-array-from-permutation/description
 */
public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
