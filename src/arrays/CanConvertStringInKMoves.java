package arrays;

/**
 * https://leetcode.com/problems/can-convert-string-in-k-moves/description/
 */
public class CanConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] shiftCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff == 0) continue;
            int timesUsed = shiftCount[diff]++;
            int moveNumber = diff + 26 * timesUsed;
            if (moveNumber > k) return false;
        }

        return true;
    }
}
