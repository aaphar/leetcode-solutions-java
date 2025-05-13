package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers/
 */
public class Finding3DigitEvenNumbers {
    // Total Space Complexity: O(1) (not counting the output array which is bounded by a constant)

    // Runs in O(n) where n is the number of digits in the input array.
    // loop runs 450 times → O(1) (constant)
    // Compares frequency maps → in the worst case, compares up to 3 unique digits → O(1).

    // Total Time Complexity:
    // O(n) (to build digit frequency map) + O(450 × 1) (loop and frequency comparison) = O(n)
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int d : digits) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }
        for (int i = 100; i < 1000; i += 2) {
            Map<Integer, Integer> freq1 = new HashMap<>();

            int digit_1 = i % 10;
            int digit_2 = (i / 10) % 10;
            int digit_3 = (i / 100) % 10;

            freq1.put(digit_1, freq1.getOrDefault(digit_1, 0) + 1);
            freq1.put(digit_2, freq1.getOrDefault(digit_2, 0) + 1);
            freq1.put(digit_3, freq1.getOrDefault(digit_3, 0) + 1);

            boolean isValid = true;
            for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
                if (freq.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(i);
            }

        }
        int[] result = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }
}
