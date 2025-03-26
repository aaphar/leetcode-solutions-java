package binarySearch;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    // Time complexity O(n log n)
    // Space complexity O(1)
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public int searchInsertForLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
