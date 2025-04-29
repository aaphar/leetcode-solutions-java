package string;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reverse-degree-of-a-string/description/
 */
public class ReverseDegreeOfAString {
    public int reverseDegree(String s) {
        // 97-122 = 26
        // 98-121 = 25
        // 99-120 = 24

        // 122-97=25
        // 122-98=24
        // 122-99=23

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += ((123 - s.charAt(i)) * (i + 1));
        }
        return result;
    }
}
