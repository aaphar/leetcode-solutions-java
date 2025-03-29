package twoPointersApproach;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] word = s.toCharArray();
        // 65, 69, 73, 79, 85
        // 97, 101, 105, 111, 117

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != 65 && l != 69 && l != 73 && l != 79 && l != 85
                    && l != 97 && l != 101 && l != 105 && l != 111 && l != 117
            ) {
                left++;
                continue;
            }

            if (r != 65 && r != 69 && r != 73 && r != 79 && r != 85
                    && r != 97 && r != 101 && r != 105 && r != 111 && r != 117
            ) {
                right--;
                continue;
            }

            word[left] = r;
            word[right] = l;
        }

        StringBuilder n = new StringBuilder();
        for (char c : word) {
            n.append(c);
        }
        return n.toString();
    }

}
