package bitManipulation;

/**
 * https://leetcode.com/problems/power-of-four/description/
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        int zero = 0;
        int one = 0;

        char[] arr = Integer.toBinaryString(n).toCharArray();
        for (char c : arr) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }

        return one == 1 && zero % 2 == 0;

    }
}
