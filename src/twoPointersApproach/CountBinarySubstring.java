package twoPointersApproach;

/**
 * https://leetcode.com/problems/count-binary-substrings/description/
 * explanationWithImages/CountBinarySubstring.png
 */
public class CountBinarySubstring {
    public static int getSubstringCount(String s) {
        // Write your code here
        // 011001 - > [ 1, 2, 2, 1, 0, 0] -> 1+2+1=4
        int[] arr = new int[s.length()];
        int index = 0;
        arr[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                index++;
                arr[index] = 1;
            } else {
                arr[index]++;
            }
        }

        int result = 0;
        for (int i = 1; i <= index; i++) {
            result += Math.min(arr[i - 1], arr[i]);
        }

        return result;
    }

    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i - 1], groups[i]);
        }
        return ans;
    }

}
