package string;

import java.util.*;

/**
 * https://leetcode.com/problems/find-the-most-common-response/
 */
public class FindTheMostCommonResponse {
    public static void main(String[] args) {
        List<List<String>> responses = List.of(
                List.of("good", "ok", "good"),
                List.of("ok", "bad"),
                List.of("bad", "notsure"),
                List.of("great", "good")
        );

//        good -2, ok -2, bad -2, notsure -1, great -1

        FindTheMostCommonResponse findTheMostCommonResponse = new FindTheMostCommonResponse();
        String result = findTheMostCommonResponse.findCommonResponse(responses);
        System.out.println(result); // Output: "good"
    }

    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (List<String> response : responses) {
            Set<String> set = Set.copyOf(response);
            for (String word : set) {
                int count = map.getOrDefault(word, 0) + 1;
                if (count > max) {
                    max = count;
                }
                map.put(word, count);
            }
        }

        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                if (result == null || entry.getKey().compareTo(result) < 0) {
                    result = entry.getKey();
                }
            }
        }

        return result;
    }
}
