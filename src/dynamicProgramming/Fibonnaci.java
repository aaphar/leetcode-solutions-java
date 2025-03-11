package dynamicProgramming;

public class Fibonnaci {

    // Most efficient for general use
    // Time complexity : O(n)
    // Space complexity : O(1)
    public int fibonnaci(int n) {
        int first = 0;
        int second = 1;
        int result = 0;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    // Time complexity : O(2^n)
    // Space complexity : O(n)
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
