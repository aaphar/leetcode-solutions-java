package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/description
 */
public class ValidAnagram {

    // Time complexity: O(2n) = O(n), where n is the length of the string
    // Space complexity: O(1)
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // increase count of element in hashmap as it occurs in s
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            // decrease count of element in hashmap as it occurs in t
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int x : hm.values()) {
            if (x != 0) return false;
        }

        return true;
    }

    // Time Complexity: O(n+m), where n is the length of s, m is the length of t
    // space complexity O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (alphabet[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            alphabet[t.charAt(i) - 'a']--;
        }
        return true;
    }


}
/**
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */