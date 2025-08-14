package august;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
 */
public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }

    public static String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        int index = 0;

        int left = 0, right = 0;

        while (right < num.length() && left <= right) {
            if (right - left + 1 == 3) {
                if (max <= num.charAt(left)) {
                    max = num.charAt(left);
                    index = left;
                }
                left = right + 1;
            } else if (num.charAt(left) != num.charAt(right)) {
                left = right;
            }

            right++;
        }

        if (max == Integer.MIN_VALUE) {
            return "";
        }

        return num.substring(index, index + 3);
    }
}
