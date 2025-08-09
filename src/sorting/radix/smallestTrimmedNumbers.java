package sorting.radix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/query-kth-smallest-trimmed-number/
 */
public class smallestTrimmedNumbers {
    public static void main(String[] args) {
        //Input: nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]

        smallestTrimmedNumbers(
                new String[]{"102", "473", "251", "814"},
                new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}}
        );

    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = nums[0].length();

        // Map: trim size → sorted indices of nums
        Map<Integer, int[]> sortedMap = new HashMap<>();

        // Initial index list: [0, 1, 2, ..., n-1]
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        // Radix sort from rightmost digit to leftmost
        for (int d = 1; d <= m; d++) {
            int digitIndex = m - d;

            // Counting sort by digit at digitIndex
            int[] count = new int[10];
            int[] tempIndices = new int[n];

            // Count digit frequencies
            for (int idx : indices) {
                int digit = nums[idx].charAt(digitIndex) - '0';
                count[digit]++;
            }

            // Prefix sum to know where to put items
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];

            // Place elements into tempIndices (from right to keep stability)
            for (int i = n - 1; i >= 0; i--) {
                int idx = indices[i];
                int digit = nums[idx].charAt(digitIndex) - '0';
                count[digit]--;
                tempIndices[count[digit]] = idx;
            }

            // Save sorted order for current trim
            sortedMap.put(d, Arrays.copyOf(tempIndices, n));

            // Update indices for next round
            indices = tempIndices;
        }

        // Answer the queries using precomputed sorts
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            result[i] = sortedMap.get(trim)[k - 1];
        }

        return result;
    }

}
