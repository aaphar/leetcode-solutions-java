package arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        productOfArrayExceptSelf.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;

        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int product = 1;
        for (int i = length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            answer[i] *= product;
        }

        return answer;
    }

    public int[] productExceptSelfB(int[] nums) {
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
