package slidingWindowDynamicSized;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixB(strs));
    }

    // TODO
    public static String longestCommonPrefixB(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int index = 0;
        for (String str : strs) {
            if (prefix.isEmpty()) {
                prefix.append(str.charAt(index));
                index++;
            } else {
                if (str.startsWith(prefix.toString())) {
                    prefix.append(str.charAt(index));
                    index++;
                } else {
                    prefix = new StringBuilder(prefix.substring(0, index - 1));
                }
            }
        }
        return prefix.toString();
    }


    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String word = strs[0];
        int index = 0;
        for (String str : strs) {
            if (str.startsWith(word.substring(0, index + 1))) {
                prefix.append(str.charAt(index));
                index++;
            } else {
                prefix = new StringBuilder(prefix.substring(0, index));
                index--;
            }
        }
        return prefix.toString();
    }
}
