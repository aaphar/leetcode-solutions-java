package twoPointersApproach;

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

    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();
    }
}
