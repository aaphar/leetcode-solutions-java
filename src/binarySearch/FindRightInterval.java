package binarySearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-right-interval/description
 */
public class FindRightInterval {

    public static void main(String[] args) {
        int[][] arr = {{1, 12}, {2, 9}, {3, 10}, {13, 14}, {15, 16}, {16, 17}};
        findRightInterval(arr);
    }

    public static int[] findRightInterval(int[][] intervals) {
        int l = intervals.length;
        if (l == 1) {
            return new int[]{-1};
        }
        int[][] intervalWithIndex = new int[l][3];

        for (int i = 0; i < l; i++) {
            intervalWithIndex[i][0] = intervals[i][0];
            intervalWithIndex[i][1] = intervals[i][1];
            intervalWithIndex[i][2] = i;
        }

        Arrays.sort(intervalWithIndex, (a, b) -> a[0] - b[0]);

        int[] result = new int[l];
        Arrays.fill(result, -1);

        for (int index = 0; index < l; index++) {
            int end = intervalWithIndex[index][1];

            int i = 0;
            int j = l - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;

                int target = intervalWithIndex[mid][0];
                if (target == end) {
                    result[intervalWithIndex[index][2]] = intervalWithIndex[i][2];
                    break;
                }
                if (target > end) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }

            if (intervalWithIndex[j][2] >= end) {
                result[intervalWithIndex[index][2]] = intervalWithIndex[j + 1][2];
            }
        }

        return result;
    }


// [[3,4],[2,3],[1,2]]

// [1, 2], [2, 3], [3, 4]

// 1, 2
//     2, 3
//         3,

// [1, 2, -1]
}
