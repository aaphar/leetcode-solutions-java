package bfs;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    }

    class Pair {
        int row;
        int column;
        int time;

        public Pair(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[] iDir = new int[]{1, -1, 0, 0};
        int[] jDir = new int[]{0, 0, 1, -1};

        int maxTime = 0, rc = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int time = p.time;

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int row = p.row + iDir[i];
                int column = p.column + jDir[i];

                if (row >= 0 && row < m && column >= 0 && column < n && grid[row][column] == 1) {
                    grid[row][column] = 2;
                    queue.add(new Pair(row, column, maxTime + 1));
                    rc++;
                }
            }
        }

        return freshOranges == rc ? maxTime : -1;
    }
}
