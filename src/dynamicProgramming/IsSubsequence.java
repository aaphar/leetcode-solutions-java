package dynamicProgramming;

/**
 * <p>
 * https://leetcode.com/problems/is-subsequence/description
 * </p>
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * </p>
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * </p>
 */
public class IsSubsequence {

    // Time complexity O(n)
    // Space complexity O(1)
    public boolean isSubsequence(String s, String t) {
        boolean result = false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int index = 0;
        if (sArr.length == 0) {
            return true;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == sArr[index]) {
                if (index == sArr.length - 1) {
                    return true;
                }
                index += 1;
            }
        }
        return result;
    }
}
