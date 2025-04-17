package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/string-compression
 */
public class StringCompression {
    public int compressBetter(char[] chars) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < chars.length) {
            char c = chars[j];
            while (j < chars.length && chars[j] == c) {
                count++;
                j++;
            }

            chars[i++] = c;
            if (count > 1) {
                String s = String.valueOf(count);
                int k = 0;
                while (k < s.length()) {
                    chars[i++] = s.charAt(k++);
                }
            }

            count = 0;

        }

        return i;
    }

    public static int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        s.append(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                if (i == chars.length - 1) {
                    s.append(count);
                }
            } else {
                if (count > 1) {
                    s.append(count);
                }
                s.append(chars[i]);
                count = 1;
            }
        }

        Arrays.fill(chars, ' ');
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }
}
