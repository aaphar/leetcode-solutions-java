package binarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4};
        search(arr, 4);
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {

            int mid = (end + start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                // left part is sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
