package sorting.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/description/
 */
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};
        minimumAbsDifference(nums);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        arr = countingSort(arr);

        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minAbsDiff) {
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    private static int[] countingSort(int[] arr) {
        int shift = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt() - shift;
        int[] counts = new int[max + 1];
        for (int i : arr) {
            counts[i - shift] += 1;
        }

        int startIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startIndex;
            startIndex += count;
        }

        int[] sorted = new int[arr.length];
        for (int element : arr) {
            sorted[counts[element - shift]] = element;
            counts[element - shift] += 1;
        }

        return sorted;
    }
}
