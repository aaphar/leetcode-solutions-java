package july;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/description
 */
public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int luckyNumber = -1;
        for (int number : map.keySet()) {
            if (map.get(number) == number) {
                luckyNumber = Math.max(luckyNumber, number);
            }
        }
        return luckyNumber;
    }

    public int findLuckyB(int[] arr) {
        if (arr.length == 0) return -1;

        int[] obeme = new int[501];

        for (int el : arr) {
            obeme[el] += 1;
        }

        for (int i = 500; i > 0; i--) {
            if (i == obeme[i]) return i;
        }

        return -1;
    }

}
