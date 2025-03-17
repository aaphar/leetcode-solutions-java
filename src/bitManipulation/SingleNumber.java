package bitManipulation;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}

/**
 * // XOR with integer values
 * int x = 5; // In binary: 0101
 * int y = 9; // In binary: 1001
 * int resultInt = x ^ y; // resultInt is 12, binary: 1100
 */


/**
 * xor operator:
 * // XOR with boolean values
 * boolean a = true;
 * boolean b = false;
 * boolean result = a ^ b; // result is true because a and b are different
 */

/**
 * a ^ a = 0 (XOR-ing a number with itself cancels it out)
 * a ^ 0 = a (XOR-ing with 0 keeps the number unchanged)
 */

