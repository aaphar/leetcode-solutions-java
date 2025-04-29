package hashmap;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description
 */
public class LongestConsecutiveSequence {

    // O(n) solution
    public int longestConsecutive(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);

                int sum = left + right + 1;
                map.put(n, sum);

                count = Math.max(count, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }

        return count;
    }
}
