package slidingWindowFixedSized;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }

    // time complexity O(n)
    // space O(n)
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }

            if (set.size() >= k + 1) {
                set.remove(nums[i]);
                i++;
            }
        }
        return false;
    }

    // Time complexity O(n^2)
    // Space complexity O(1)
    public static boolean containsNearbyDuplicateMemoryEfficient(int[] nums, int k) {
        for (int left = 0; left <
                nums.length; left++) {
            int index = left + 1;
            while (index <= left + k && index < nums.length) {
                if (nums[left] == nums[index]) {
                    return true;
                }
                index++;
            }

        }
        return false;
    }
}
