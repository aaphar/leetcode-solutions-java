package slidingWindowFixedSized;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagramsInAString {

    // TODO
    public static void main(String[] args) {
        String s = "baa", p = "aa";
        List<Integer> integers = findAnagrams(s, p);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency arrays for s and p
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // Check if the current window is an anagram
            if (areArraysEqual(pCount, sCount)) result.add(i);

            // Slide the window
            if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--; // Remove old char from the count
                sCount[s.charAt(i + p.length()) - 'a']++; // Add new char to the count
            }
        }

        return result;
    }

    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

/**
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
