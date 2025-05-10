package string;

/**
 * https://leetcode.com/contest/biweekly-contest-156/problems/find-most-frequent-vowel-and-consonant/
 */
public class FindMostFrequentVowelAndConsonant {

    public int maxFreqSum(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        int maxVowel = 0;
        int maxCons = 0;
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                if (maxVowel < letters[i]) {
                    maxVowel = letters[i];
                }
            } else {
                if (maxCons < letters[i]) {
                    maxCons = letters[i];
                }
            }
        }

        return maxCons + maxVowel;
    }
}
