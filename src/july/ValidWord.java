package july;

/**
 * https://leetcode.com/problems/valid-word
 */
public class ValidWord {
    public static void main(String[] args) {
        System.out.println(isValid("UuE6"));
    }

    public static boolean isValid(String word) {
        // [0-9]
        // [65-90]
        // [97-122]
        // a, e, i, o, u
        // 65, 69, 73, 79, 85
        // 97, 101, 105, 111, 117
        String VOWELS = "aeiouAEIOU";
        if (word.length() < 3) {
            return false;
        }

        boolean vowel = false;
        boolean consonant = false;

        for (char c : word.toCharArray()) {
            if ((c > 57 && c < 65) ||
                    (c > 90 && c < 97) ||
                    c > 122 || c < 48) {
                return false;
            }

            if (VOWELS.indexOf(c) != -1) {
                vowel = true;
            } else if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                consonant = true;
            }

        }

        return vowel && consonant;
    }
}
