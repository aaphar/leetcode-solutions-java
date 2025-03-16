package dynamicProgramming;

/**
 * <p>
 * https://leetcode.com/problems/counting-bits/description/?envType=problem-list-v2&envId=2lhxgujc
 * </p>
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * </p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * <p>
 * 0 --> 0
 * </p>
 * <p>
 * 1 --> 1
 * </p>
 * <p>
 * 2 --> 10
 * </p>
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        int pow = 1;
        for (int i = 1, t = 0; i <= n; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            ret[i] = ret[t] + 1;
        }
        return ret;
    }
}


/**
 * pow=1
 * i=1
 * t=0;
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 0+1
 *
 * pow=2
 * i=2
 * t=0
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 1, 0+1
 *
 * pow=2
 * i=3
 * t=1
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 1, 1, 1+1
 *
 * pow=4
 * i=4
 * t=0
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 1, 1, 2, 0+1
 *
 * pow=8
 * i=5
 * t=1
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 1, 1, 2, 1, 1+1
 *
 * pow=8
 * i=6
 * t=2
 * 0, 1, 2, 3, 4, 5, 6
 * 0, 1, 1, 2, 1, 2, 1+1
 *
 */