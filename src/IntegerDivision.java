/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class IntegerDivision {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(divide(-2147483648, 1));
        System.out.println(" ms " + (System.currentTimeMillis() - start));
    }


//    public static int findDivision(int n, int k) {
//        if (k == 0) throw new ArithmeticException("Division by zero");
//        if (n < k) return 0; // base case: quotient is 0
//        if (n == k) return 1; // base case: quotient is exactly 1
//
//        int totalCount = 0;
//        int divider = k;
//        int multiple = 1; // how many times we’ve added k so far
//
//        // Double the divisor until the next double would be too big
//        while (divider + divider <= n) {
//            divider += divider; // same as divider *= 2
//            multiple += multiple; // same as multiple *= 2
//        }
//
//        // Subtract the largest chunk and count how many times k it represents
//        n -= divider;
//        totalCount += multiple;
//
//        // Recursively handle the remainder
//        totalCount += findDivision(n, k);
//
//        return totalCount;
//    }

    public static long divide(int n, int k) {
        boolean negative = (n < 0) ^ (k < 0);

        if (n < k)
            return 0;

        if (n == k)
            return 1;

        int totalCount = 0;
        int count = 0;
        int divider = k;

        while (n >= k) {
            if (n < divider) {
                totalCount += divide(n, k);
                break;
            } else {
                n -= divider;
                totalCount += count + 1;
            }

            divider += divider;

            count++;
        }
        return negative ? -totalCount : totalCount;

    }
}

// 11, 2, +1
// 9, 4, +2
// 5, 8,


// 5, 2 +1
// 3, 4,

// 3, 2, +1
// 1, 2,
