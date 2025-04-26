package string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description
 */
public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        String word1 = "uau";
        String word2 = "ssx";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for (char c : word1.toCharArray()) {
            ch1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            ch2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((ch1[i] == 0 && ch2[i] != 0) || (ch1[i] != 0 && ch2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i = 0; i < 26; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }

        return true;
    }
}
