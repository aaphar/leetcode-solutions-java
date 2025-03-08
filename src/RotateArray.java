/**
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * length = 7
     * 0 1 2 3 4 5 6
     * 4 5 6 0 1 2 3
     *
     * @param nums
     * @param k
     */

//    public static void rotate(int[] nums, int k) {
//        int[] result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            result[(i + k) % nums.length] = nums[i];
//        }
//
//        System.arraycopy(result, 0, nums, 0, nums.length);
//    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
