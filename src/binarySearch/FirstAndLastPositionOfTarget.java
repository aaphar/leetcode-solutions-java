package binarySearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastPositionOfTarget {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int first = -1;
        int last = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                first = mid;
                last = mid;
                while (first - 1 >= 0 && nums[first - 1] == target) {
                    first--;
                }
                while (last + 1 < nums.length && nums[last + 1] == target) {
                    last++;
                }
                return new int[]{first, last};
            }
        }

        return new int[]{last, first};
    }
}
