package binarySearch;

/**
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // 0-16 -> 8
        // 0-8 -> 4

        // 0-14 -> 7
        // 0-7 -> 3
        if (num == 1 || num == 0) {
            return true;
        }
        long start = 0, end = num;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqr = mid * mid;
            if (sqr == num) {
                return true;
            } else if (sqr > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;

    }
}
