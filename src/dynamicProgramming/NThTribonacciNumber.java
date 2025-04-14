package dynamicProgramming;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/description/
 */
public class NThTribonacciNumber {
    public int tribonacci(int n) {
        // 4 -> s=1, 3 -> s1=2,
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int num1 = 0;
        int num2 = 1;
        int num3 = 1;
        while (n >= 3) {
            int s = num1 + num2 + num3;
            num1 = num2;
            num2 = num3;
            num3 = s;
            n--;
        }

        return num3;
    }
}
