package sorting.bucket;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3333};
        topKFrequent(arr, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            result.addAll(buckets[i]);
        }

        return result.stream().mapToInt(i -> i).limit(k).toArray();
    }
}
