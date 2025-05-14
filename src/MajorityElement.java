import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    //  Boyer-Moore Voting Algorithm.
    // Time complexity O(n)
    // Space complexity O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElementW(int[] nums) {
        AtomicInteger result = new AtomicInteger();
        int majority = nums.length / 2;
        Map<Integer, Integer> elementCount = new HashMap<>();
        for (int num : nums) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }

        elementCount.forEach((k, v) -> {
            if (v > majority) {
                result.set(k);
            }
        });

        return result.get();
    }
}
