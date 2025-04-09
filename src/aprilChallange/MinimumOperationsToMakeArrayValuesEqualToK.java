package aprilChallange;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/
 */
public class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        // This is just a fancier way to say return the number of distinct integers in the array that are greater than k.

        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();
    }

    public int minOperationsBetterRunTime(int[] nums, int k) {
        boolean[] has = new boolean[101];

        for (int num : nums) {
            has[num] = true;
        }
        int cnt = 0;
        for (int i = 0; i < has.length; i++) {
            if (!has[i]) continue;

            if (has[i] && i < k)
                return -1;
            else if (has[i] && i > k)
                cnt++;
        }
        return cnt;
    }
}
