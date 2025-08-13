package prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        System.out.println(checkSubarraySum(nums, 6));
    }


    public static boolean checkSubarraySumM(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int start = map.getOrDefault(sum % k, 0);
            if (start != 0) {
                if (i - start > 1) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }

        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the first occurrence of each modulo value.
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // Important: Handles cases where a valid subarray starts from index 0.

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i]; // Increment the running sum
            int mod = runningSum % k; // Compute modulo with k

            // If mod is negative, adjust it to be positive
            if (mod < 0) mod += k;

            // Check if this mod has appeared before
            if (modMap.containsKey(mod)) {
                // Verify the subarray is longer than size 1
                if (i - modMap.get(mod) > 1) {
                    return true;
                }
            } else {
                // Store the index of the first time we see this mod
                modMap.put(mod, i);
            }
        }
        return false; // No valid subarray found
    }
}

/**
 * explanationWithImages/continuosSubarraySum.png
 * explanationWithImages/continuosSubarraySum2.png
 * nums={23,2,4,6,6} k=6
 * sum1=nums[0]
 * sum2=nums[0]+nums[1]+nums[2]
 * sum2-sum1=2+4 => 6%6=0
 * (sum2-sum1)%k==0
 * sum2%k==sum1%k
 * if 2 remaining is equal then there are numbers which can be divided by k in them.
 */
