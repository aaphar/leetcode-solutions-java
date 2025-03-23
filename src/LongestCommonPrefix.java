/**
 * https://leetcode.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {

    // horizontal scanning
    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    // Space complexity : O(1)
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // vertical scanning
    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    // Space complexity : O(1)
    public String longestCommonPrefixVerticalScanning(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (
                        i == strs[j].length() || strs[j].charAt(i) != c
                ) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // divide and conquer
    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    // Space complexity : O(m * log n)
    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // binary search
    // Time complexity : O(S * log n) , where S is the sum of all characters in all strings.
    // Space complexity : O(1)
    public String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) low = middle + 1;
            else high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) if (
                !strs[i].startsWith(str1)
        ) return false;
        return true;
    }
}
