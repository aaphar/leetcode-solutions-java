package math;

/**
 * https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/
 */
public class CheckDivisibilityByDigitSumAndProduct {

    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));
    }

    public static boolean checkDivisibility(int n) {
        int number = n;
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;

            n /= 10;
        }
        sum += product;

        return number % sum == 0;
    }
}
