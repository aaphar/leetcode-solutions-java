/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int initialNum = x;
        int newNum = 0;
        while (x > 0) {
            int remainder = x % 10;
            x /= 10;
            newNum = newNum * 10 + remainder;
        }

        return newNum == initialNum;
    }
}
