package math;

public class GreatestCommonDivision {
    //    We calculate the GCD using binary Euclidean algorithm, it takes log(m⋅n) time.
    // Time complexity: O(log(min(a, b)))
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
