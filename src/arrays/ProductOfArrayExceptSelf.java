package arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int products = 1;
        boolean containsZero = false;
        for (int num : nums) {
            if (num == 0 && !containsZero) {
                containsZero = true;
            } else {
                products *= num;
            }
        }
        int[] answers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && containsZero) {
                answers[i] = 0;
            } else if (nums[i] == 0 && containsZero) {
                answers[i] = products;
            } else {
                if (products == 0) {
                    answers[i] = products;
                } else {
                    answers[i] = products / nums[i];
                }
            }
        }
        return answers;
    }
}
