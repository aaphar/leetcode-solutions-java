package slidingWindowDynamicSized;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while (left <= right && right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

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

    public static int lengthOfLongestSubstringConstantSpace(String s) {
        int n = s.length();
        int start = 0;
        int res = 0;
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        for (int end = 0; end < n; end++) {
            char current = s.charAt(end);
            start = Math.max(start, lastIndex[current] + 1);
            res = Math.max(res, end - start + 1);
            lastIndex[current] = end;
        }
        return res;

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
