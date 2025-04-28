package binarySearch;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {
        int l = 1;
        int h = n;
        int m;
        while (l <= h) {
            m = l + (h - l) / 2;
            int g = Integer.compare(6, m);

            if (g == -1) {
                h = m - 1;

            } else if (g == 1) {
                l = m + 1;

            } else {
                return m;
            }
        }

        return -1;
    }
}
