package hashmap;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]

//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String word = Arrays.toString(sorted);
            List<String> words = map.getOrDefault(word, new ArrayList<>());
            words.add(str);
            map.put(word, words);

        }

        return new ArrayList<>(map.values());
    }
}
