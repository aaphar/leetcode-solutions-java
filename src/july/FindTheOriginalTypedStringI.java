package july;

/**
 * https://leetcode.com/problems/find-the-original-typed-string-i/description
 */
public class FindTheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
