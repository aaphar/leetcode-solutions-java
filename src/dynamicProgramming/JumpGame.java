package dynamicProgramming;

/**
 * https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * * Input: nums = [2,3,1,1,4]
 * * Output: true
 * * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * * Input: nums = [3,2,1,0,4]
 * * Output: false
 * * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * * which makes it impossible to reach the last index.
 * *
 * * @param nums
 * * @return
 */

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};

        System.out.println(canJump(arr));
    }

    // greedy approach.
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}

/**
 * Step	    Index i	  nums[i]	Reachable Before	i + nums[i]	    Reachable After	                Can Continue?
 * 1	    0	        2	        0	                0 + 2 = 2	        2	                        ✅ Yes
 * 2	    1	        3	        2	                1 + 3 = 4	        4	                        ✅ Yes
 * 3	    2	        1	        4	                2 + 1 = 3	        4 (unchanged)	            ✅ Yes
 * 4	    3	        1	        4	                3 + 1 = 4	        4 (unchanged)	            ✅ Yes
 * 5	    4	        4	        4	                4 + 4 = 8	        8 (beyond last index)	    ✅ Yes
 *
 *
 *
 *
 *
 *
 * Step	    Index i	    nums[i]	    Reachable Before	i + nums[i]	    Reachable After	    Can Continue?
 * 1	    0	            3	            0	         0 + 3 = 3	        3	                ✅ Yes
 * 2	    1	            2	            3	         1 + 2 = 3	        3	                ✅ Yes
 * 3	    2	            1	            3	         2 + 1 = 3	        3	                ✅ Yes
 * 4	    3	            0	            3	         3 + 0 = 3	        3 (unchanged)	    ✅ Yes
 * 5	    4	            4	            3	         4 + 4 = 8	        ❌ (index 4 is unreachable)
 */
