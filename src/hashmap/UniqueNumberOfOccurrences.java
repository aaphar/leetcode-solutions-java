package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description
 */

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put((arr[i]), 1 + map.get(arr[i]));
            } else map.put(arr[i], 1);
        }

        Set<Integer> set = new HashSet();
        for (int i : map.values()) {
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }

        return true;
    }


    public boolean uniqueOccurrencesWithArray(int[] arr) {
        int[] occurences = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            occurences[arr[i] + 1000]++;
        }
        int[] unique = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            int curr = occurences[arr[i] + 1000];
            if (curr > 0) {
                unique[curr]++;
                if (unique[curr] > 1) {
                    return false;
                }
                occurences[arr[i] + 1000] = -curr;
            }
        }
        return true;
    }
}