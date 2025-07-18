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
        int start = 0, end = nums.length - 1;

        int first = -1, second = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                first = mid;
                second = mid;
                while (first > 0 && nums[first - 1] == target) {
                    first--;
                }
                while (second < nums.length - 1 && nums[second + 1] == target) {
                    second++;
                }
                break;

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{first, second};
    }
}
