package aprilChallange;

/**
 * https://leetcode.com/problems/count-symmetric-integers/description/
 */
public class CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1200, 1230)); // 0
    }

    /**
     * If it is a two-digit number and is a multiple of 11, then it is a symmetric integer.
     * If it is a four-digit number, calculate the sum of the thousands and hundreds digits,
     * as well as the sum of the tens and ones digits. If they are equal, it is a symmetric (even) integer.
     *
     * @param low
     * @param high
     * @return
     */
    public int countSymmetricIntegersBetter(int low, int high) {
        int res = 0;
        for (int a = low; a <= high; ++a) {
            if (a < 100 && a % 11 == 0) {
                res++;
            } else if (1000 <= a && a < 10000) {
                int left = a / 1000 + (a % 1000) / 100;
                int right = (a % 100) / 10 + (a % 10);
                if (left == right) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            int countOfDigits = findCountOfDigits(i); // 4
            if (countOfDigits % 2 != 0) {
                continue;
            }

            int number = i;
            int secondSum = 0;
            int symmetricL = countOfDigits / 2; // 2
            // check if number is symmetric
            while (countOfDigits > symmetricL) {
                secondSum += number % 10;
                number /= 10;
                countOfDigits--;
            }
            int firstSum = 0;
            while (countOfDigits > 0) {
                firstSum += number % 10;
                number /= 10;
                countOfDigits--;
            }

            if (secondSum == firstSum) {
                result++;
            }
        }
        return result;
    }

    public static int findCountOfDigits(int number) {
        return (int) (Math.log10(number) + 1);
    }
}
