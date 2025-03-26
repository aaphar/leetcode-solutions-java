import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description
 */
public class PlusOne {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && digits[i] == 9) {
                int[] arr = Arrays.copyOf(digits, digits.length + 1);
                arr[0] = 1;
                return arr;
            }
            if (digits[i] < 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        return digits;
    }
}
