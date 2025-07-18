package binarySearch;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {8, -2, -2, -2, -4, -5, -5},
                {-2, -3, -3, -4, -4, -5, -5},
                {-2, -5, -5, -5, -5, -5, -5},
                {-3, -5, -5, -5, -5, -5, -5},
                {-5, -5, -5, -5, -5, -5, -5},
                {-5, -5, -5, -5, -5, -5, -5},
                {-5, -5, -5, -5, -5, -5, -5},
                {-5, -5, -5, -5, -5, -5, -5},
                {-5, -5, -5, -5, -5, -5, -5}
        };
        System.out.println(countNegatives(arr));

    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int col = grid[0].length;

        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][0] < 0) {
                count += grid[i].length;
                continue;
            }

            if (grid[i][col - 1] > 0) {
                continue;
            }
            int start = 0, end = col - 1;

            while (start <= end) {

                int mid = start + (end - start) / 2;

                if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            count += (col - start);
        }


        return count;
    }
}
