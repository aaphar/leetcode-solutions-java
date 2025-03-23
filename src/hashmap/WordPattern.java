package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern
 */
public class WordPattern {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.trim().split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String value = map.getOrDefault(pattern.charAt(i), null);
            if (value == null && map.containsValue(arr[i])) {
                return false;
            }
            if (value != null && !value.equals(arr[i])) {
                return false;
            }
            map.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }
}

/**
 * pattern = "abba", s = "dog cat cat dog"
 */