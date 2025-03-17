package twoPointersApproach;

/**
 * https://leetcode.com/problems/valid-parentheses
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeWithChar(s));
    }

    public static boolean isPalindrome(String s) {
        String[] sArr = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split("");
        int left = 0;
        int right = sArr.length - 1;
        while (left < right) {
            if (!sArr[left].equals(sArr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeWithChar(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
