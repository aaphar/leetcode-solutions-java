package set;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-mismatch/
 */

public class SetMismatch {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int duplicate = -1, missing = -1;

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) duplicate = i;
            if (count[i] == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] findErrorNumsWithSet(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet();
        int duplicate = -1;
        int sumOfSet = 0;
        int sumOfNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                duplicate = nums[i];
            } else {
                set.add(nums[i]);
                sumOfSet += nums[i];
            }
            sumOfNums += (i + 1);
        }

        result[0] = duplicate;
        result[1] = sumOfNums - sumOfSet;

        return result;
    }
}
