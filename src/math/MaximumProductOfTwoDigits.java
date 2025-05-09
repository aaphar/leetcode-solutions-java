package math;

/**
 * https://leetcode.com/problems/maximum-product-of-two-digits/
 */
public class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        int[] count = new int[10];

        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        int max = 0;
        int secondMax = 0;
        for (int i = 9; i >= 0; i--) {
            if (count[i] != 0) {
                if (max == 0) {
                    max = i;
                    if (count[i] > 1) {
                        secondMax = i;
                    }
                } else if (secondMax == 0) {
                    secondMax = i;
                } else {
                    break;
                }
            }
        }

        return secondMax * max;
    }
}
