package aprilChallange;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/
 */
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {


    // Time complexity: O(n)
    // Space complexity: O(n)

    /**
     * int[] nums = {1, 2, 3, 2, 4, 5};
     * 1.	Start from the end (i = 5 → 0), keep adding elements to a set or a seen[] array.
     * 2.	At i = 5: 5 → not seen → add to seen ✅
     * i = 4: 4 → not seen → add to seen ✅
     * i = 3: 2 → not seen → add to seen ✅
     * i = 2: 3 → not seen → add to seen ✅
     * i = 1: 2 → already seen ❌ → duplicate found!
     * operations = i / 3 + 1
     *
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }


    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int minimumOperationsNS(int[] nums) {
        int index = 0;
        int ans = 0;

        while (index < nums.length) {
            Set<Integer> s = new HashSet();
            boolean hasDuplicate = false;
            for (int i = index; i < nums.length; i++) {
                if (!s.add(nums[i])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) {
                return ans;
            }

            index += 3;
            ans++;
        }
        return ans;
    }


    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public int minimumOperationsE(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 3, ans++) {
            if (checkUnique(nums, i)) {
                return ans;
            }
        }
        return ans;
    }

    private boolean checkUnique(int[] nums, int start) {
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (cnt.contains(nums[i])) {
                return false;
            }
            cnt.add(nums[i]);
        }
        return true;
    }


}
