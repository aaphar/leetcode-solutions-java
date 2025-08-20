package binarySearch;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicateBinary(arr));
    }

    /**
     * Hint 2: Binary search on value range
     * <p>
     * You don’t need to touch the array order; instead, you can count how many numbers are ≤ mid.
     * <p>
     * If the count is greater than mid, the duplicate is in the lower half; else it’s in the upper half.
     * <p>
     * This works because of the pigeonhole principle: there are n+1 numbers but only n possible values.
     *
     * @param nums
     * @return
     */

    public static int findDuplicateBinary(int[] nums) {
        int left = 1, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int num : nums) {
                if (num < mid) {
                    count++;
                }
            }

            if (count >= mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to the cycle (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    //1, 2, 3,4, 4, 6, 7
}
