import java.util.Arrays;

/***
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    // Greedy approach
    // explanationWithImages/JumpGameIIGreedyApproach.png
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int jump(int[] nums) {
        int jumps = 0, currentFarthest = 0, currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            if (i == currentEnd) {
                currentEnd = currentFarthest;
                jumps++;
            }
        }
        return jumps;
    }


    // Dynamic programming approach
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public static int jumpDynamic(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); // Fill with large values
        dp[0] = 0; // No jumps needed to reach the start

        for (int i = 1; i < n; i++) { // Iterate through each position
            for (int j = 0; j < i; j++) { // Check all previous positions
                if (j + nums[j] >= i) { // Can we jump to index i from j?
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1]; // Minimum jumps needed to reach the last index
    }
}
