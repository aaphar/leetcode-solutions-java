package twoPointersApproach;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    /**
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * @param nums
     */

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    /**
     * explanationWithImages/MoveZeroes.png
     *
     * l=0; r=0; [0, 1, 0, 3, 12]
     * l=0; r=1; [1, 0, 0, 3, 12]
     * l=1; r=2; [1, 0, 0, 3, 12]
     * l=1; r=3; [1, 3, 0, 0, 12]
     * l=2; r=4; [1, 3, 12, 0, 0]
     */
}
