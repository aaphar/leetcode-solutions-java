package twoPointersApproach;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {-1, -2, -3, -4, -5};
        int[] result = twoSum(numbers, -8);

        for (int i : result) {
            System.out.println(i);
        }
    }
    // 1, 2, 4, 5, 7
    // 12
    // 7

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (!map.containsKey(nums[i])) {
                map.put(remaining, i);
            } else {
                int index = map.get(nums[i]);
                return new int[]{index, i};
            }
        }
        return new int[]{};
    }
}
