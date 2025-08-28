package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/description/
 */
public class _01Matrix {

    class Pair {
        int row;
        int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] output = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    output[i][j] = 0;
                    queue.add(new Pair(i, j)); // enqueue all 0s
                } else {
                    output[i][j] = -1; // mark unvisited
                }
            }
        }

        int[] iDir = new int[]{1, -1, 0, 0};
        int[] jDir = new int[]{0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = pair.row + iDir[i];
                int col = pair.column + jDir[i];

                if (row >= 0 && row < m && col >= 0 && col < n
                        && output[row][col] == -1) {
                    output[row][col] = output[pair.row][pair.column] + 1;
                    queue.add(new Pair(row, col));
                }
            }
        }

        return output;
    }
}
