package dynamicProgramming;

/**
 * <p>
 * https://leetcode.com/problems/climbing-stairs/description/
 * </p>
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * </p>
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * </p>
 */
public class ClimbingStairs {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    // like fibonnaci series
    // 1, 1, 2, 3, 5, 8, 13, 21, 34
// index:  0, 1, 2, 3, 4, 5, 6, 7, 8,

    // Time complexity O(n)
    public static int climbStairs(int n) {
        if (n <= 1) return n;

        int prev2 = 1, prev1 = 2;  // prev2 is for n=1, prev1 is for n=2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;  // Return the number of ways to reach step n
    }


    // Time complexity O(2^n)
//    public static int climbStairs(int n) {
//        if (n == 0) {
//            count += 1;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
//
//    //1134903170
//    //1134903170
//
    // Time complexity O(2^n)
//    // this example cause Time Limit Exceeded
//    public static int climbStairs(int n) {
//        if (n == 0) {
//            count += 1;
//        }
//        if (n >= 1) {
//            climbStairs(n - 1);
//        }
//        if (n >= 2) {
//            climbStairs(n - 2);
//        }
//        return count;
//    }
}


/**
 * Initial values:
 * •	For n = 1: There’s only 1 way to get to step 1: (1).
 * •	For n = 2: There are 2 ways to get to step 2: (1+1) or (2).
 * <p>
 * Iteration Process:
 * •	Step 3: To reach step 3, you can:
 * •	Come from step 2 (1 step): 2 ways.
 * •	Come from step 1 (2 steps): 1 way.
 * So, total ways to reach step 3 = 2 + 1 = 3.
 * •	Step 4: To reach step 4, you can:
 * •	Come from step 3 (1 step): 3 ways.
 * •	Come from step 2 (2 steps): 2 ways.
 * So, total ways to reach step 4 = 3 + 2 = 5.
 * •	Step 5: To reach step 5, you can:
 * •	Come from step 4 (1 step): 5 ways.
 * •	Come from step 3 (2 steps): 3 ways.
 * So, total ways to reach step 5 = 5 + 3 = 8.
 */