package juneChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public int maxDifference(String s) {
        int max = 1;
        int min = s.length();
        Map<Character, Integer> map = new HashMap();

        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }

        for (int i : map.values()) {
            if (i % 2 == 1) {
                max = Math.max(max, i);
            } else {
                min = Math.min(min, i);
            }
        }
        return max - min;
    }
}
