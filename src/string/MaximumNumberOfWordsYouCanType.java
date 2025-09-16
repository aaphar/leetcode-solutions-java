package string;

/**
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/
 */
public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        int[] brokenArr = new int[26];
        for (char c : brokenLetters.toCharArray()) {
            brokenArr[c - 'a']++;
        }

        for (String word : text.split(" ")) {
            boolean broken = false;
            for (char c : word.toCharArray()) {
                if (brokenArr[c - 'a'] > 0) {
                    broken = true;
                    break;
                }
            }

            if (!broken) {
                count++;
            }
        }

        return count;
    }
}
