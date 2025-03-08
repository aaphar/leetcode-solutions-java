package prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * </p>
 * <p>
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * </p>
 * </p>
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
/**
 *
 Prefix Sum Concept:
 Compute the running sum of the array while iterating through it.
 If at any index, the difference between the running sum and ( k ) (i.e., current_sum - k) exists in the hashmap, it indicates a subarray ending at the current index whose sum equals ( k ).

 HashMap Usage:
 Use a hashmap to store the frequency of prefix sums encountered so far. This allows constant-time checks to determine if a required prefix sum exists.

 */