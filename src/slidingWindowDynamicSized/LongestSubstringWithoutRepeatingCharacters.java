package slidingWindowDynamicSized;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> duplicates = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (right < s.length() && left < s.length()) {
            if (duplicates.contains(s.charAt(right))) {
                duplicates.remove(s.charAt(left));
                left++;
            } else {
                duplicates.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, duplicates.size());
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringBetterRunTime(String s) {
        Map<Character, Integer> duplicates = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (duplicates.containsKey(s.charAt(right))) {
                left = Math.max(left, duplicates.get(s.charAt(right)) + 1);
            }
            duplicates.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringLessBetterApproach(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> elementCount = new HashMap<>();
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i + maxLength < s.length(); i++) {
            int length = 0;
            while (index < s.length()) {
                if (!elementCount.containsKey(s.charAt(index))) {
                    elementCount.put(s.charAt(index), index);
                    length++;
                    index++;
                } else {
                    index = i + 1;
                    break;
                }
            }
            if (maxLength < length) {
                maxLength = length;
            }
            elementCount.clear();
        }
        return maxLength;
    }
}
/**
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
