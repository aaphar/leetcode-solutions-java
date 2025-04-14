package hashmap;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description
 */
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays obj = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = {-68, -80, -19, -94, 82, 21, -43};
        int[] nums2 = {-63};
        System.out.println(obj.findDifference(nums1, nums2)); // Expected: [[1,3],[4,6]]
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }

        for (int i = 0; i < Math.min(nums1.length, nums2.length); i++) {
            if (list2.contains(nums1[i])) {
                list1.remove(nums1[i]);
                list2.remove(nums1[i]);
            }

            if (list1.contains(nums2[i])) {
                list2.remove(nums2[i]);
                list1.remove(nums2[i]);
            }
        }
        return Arrays.asList(new ArrayList<>(list1), new ArrayList<>(list2));
    }
}
