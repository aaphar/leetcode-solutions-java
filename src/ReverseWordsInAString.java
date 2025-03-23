/**
 * https://leetcode.com/problems/reverse-words-in-a-string
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    // Time complexity : O(n)
    // Space complexity : O(n)
    public static String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) {
                continue;
            }
            result.append(arr[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}

/**
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 */
