package slidingWindowDynamicSized;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] sArr = new int[126];
        int[] tArr = new int[126];
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;
        }

        int left = 0, right = 0;

        while (right < s.length()) {
            sArr[s.charAt(right)]++;

            while (tArrEqual(tArr, sArr)) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    start = left;
                    end = right + 1;
                }

                sArr[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return s.substring(start, end);
    }

    private static boolean tArrEqual(int[] tArr, int[] sArr) {
        for (int i = 0; i < 126; i++) {
            if (tArr[i] > 0 && sArr[i] < tArr[i]) {
                return false;
            }
        }

        return true;
    }
}
