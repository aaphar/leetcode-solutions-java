package prefixSumPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 * <p>
 * https://leetcode.com/problems/contiguous-array/description/
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(nums));

    }

    public static int findMaxLengthN(int[] nums) {
        // 0+1=1
        // 1+1=0

        // [0, 1, 1, 1, 1, 1, 0, 0, 0]
        //  -1, 0, 1, 2, 3, 4, 3, 2, 1,
        //  0, 1, 2, 3, 4, 5, 5, 5, 5,

        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] == 0 ? -1 : 1;
            sum += num;

            int index = map.getOrDefault(sum, -2);
            if (index != -2) {
                max = Math.max(max, i - index);

            } else {
                map.put(sum, i);
            }
        }

        return max;

    }

    public int findMaxLengthLessEfficient(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int ones = 0, zeros = 0, maxlen = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else ones++;
            int diff = zeros - ones;

            if (map.containsKey(diff)) {
                maxlen = Math.max(maxlen, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxlen;

    }

    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max, i - last);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

}

/**
 * nums = [0,1,1,1,1,1,0,0,0]
 * Converted: [-1,1,1,1,1,1,-1,-1,-1]
 * <p>
 * Map stores first occurrence of each sum:
 * sum -1 → index 0
 * sum  0 → index -1  (important for full length)
 * sum  1 → index 2
 * sum  2 → index 3
 * sum  3 → index 4
 * sum  4 → index 5
 * sum  3 → index 6  (Found again, subarray length 6-4 = 2)
 * sum  2 → index 7  (Found again, subarray length 7-3 = 4)
 * sum  1 → index 8  (Found again, subarray length 8-2 = 6)
 * <p>
 * <p>
 * <p>
 * •	Why do we take max?
 * •	We are tracking the longest subarray with equal 0s and 1s.
 * •	Every time we see a sum that we’ve seen before, it means the numbers between those two indices balance out.
 * •	We check all such subarrays and take the maximum length.
 * •	Why do we store the first occurrence of each sum?
 * •	This ensures we maximize the subarray length by taking the earliest index where the sum appeared.
 * •	Why does it work?
 * •	A sum that repeats means that the values in between sum to 0, meaning equal 0s and 1s.
 */

/**
 * Example 1:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 */