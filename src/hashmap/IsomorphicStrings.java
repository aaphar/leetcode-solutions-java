package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    // Time complexity: O(n), where n is the length of the string
    // Space complexity: O(1)
    // best if we know the input is ASCII
    public static boolean isIsomorphicBest(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sToT = new int[256]; // ASCII mappings
        int[] tToS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sToT[c1] == 0 && tToS[c2] == 0) {
                sToT[c1] = c2;
                tToS[c2] = c1;
            } else if (sToT[c1] != c2 || tToS[c2] != c1) {
                return false;
            }
        }
        return true;
    }


    // Time complexity: O(n), where n is the length of the string
    // Space complexity: O(1)
    public boolean isIsomorphicBestTimeComplexity(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sToT.containsKey(c1) && sToT.get(c1) != c2) return false;
            if (tToS.containsKey(c2) && tToS.get(c2) != c1) return false;

            sToT.put(c1, c2);
            tToS.put(c2, c1);
        }
        return true;
    }

    // Time complexity: O(n), worst case O(n^2) where n is the length of the string, because of the containsValue method
    // Space complexity: O(1)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                // check if value equal c2
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // if key is not in the map check if value is in the map
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }


}

//Input: s = "egg", t = "add"
