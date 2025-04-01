package twoPointersApproach;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(nums, 2));
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

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (i >= 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && (
                        (i < flowerbed.length - 1 && flowerbed[i + 1] == 0)
                                || (i == flowerbed.length - 1)
                )) {
                    n--;
                    flowerbed[i] = 1;
                    i++;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                    i++;
                }
            }
        }
        return n == 0;
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
