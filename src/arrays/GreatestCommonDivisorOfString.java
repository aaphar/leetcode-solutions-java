package arrays;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings
 */
public class GreatestCommonDivisorOfString {
    // Time complexity: O(m + n)
    // Space complexity: O(m + n)
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdL = gcd(l1, l2);
        return str1.substring(0, gcdL);
    }

    // calculate the GCD using binary Euclidean algorithm, it takes log(m⋅n) time.
    public int gcd(int l1, int l2) {
        if (l2 == 0) {
            return l1;
        } else {
            return gcd(l2, l1 % l2);
        }
    }
}
