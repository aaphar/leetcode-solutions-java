package twoPointersApproach;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * </p>
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * </p>
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * </p>
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * </p>
 * <p>
 * Your solution must use only constant extra space.
 * </p>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] twoSumTwoPointerApproach(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                System.gc();
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{-1, -1};
    }


    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int remaining = target - numbers[i];
            if (map.containsKey(remaining)) {
                result = new int[]{map.get(remaining) + 1, i + 1};
                return result;
            } else {
                map.put(numbers[i], i);
            }
        }

        return result;
    }
}

/**
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 */
