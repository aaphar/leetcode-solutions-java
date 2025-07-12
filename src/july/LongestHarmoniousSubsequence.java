package july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/description
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }

    public int findLHSMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int length = map.get(num) + map.get(num + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
