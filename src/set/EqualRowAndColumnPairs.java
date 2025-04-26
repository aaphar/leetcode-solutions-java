package set;

import java.util.*;

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/
 */
public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int[][] arr = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(equalPairs(arr));
    }

    // hashing array values
    public int equalPairsH(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> mapper = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int s = hashRowArray(grid[i]);
            mapper.put(s, mapper.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int s = hashColArray(grid, i);
            counter += mapper.getOrDefault(s, 0);
        }

        return counter;
    }

    private int hashColArray(int[][] grid, int index) {
        int hashValue = 0;
        for (int i = 0; i < grid.length; i++) {
            hashValue = hashValue * 5 + grid[i][index];
        }
        return hashValue;
    }

    private int hashRowArray(int[] array) {
        int hashValue = 0;
        for (int num : array) {
            hashValue = hashValue * 5 + num;
        }
        return hashValue;
    }

    // using hashmap
    public static int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] r : grid) {
            List<Integer> row = new ArrayList<>(r.length);
            for (int anInt : r) {
                // column pair
                row.add(anInt);
            }

            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            int rowL = grid[i].length;
            List<Integer> column = new ArrayList<>(rowL);
            for (int j = 0; j < rowL; j++) {
                // column pair
                column.add(grid[j][i]);
            }

            if (map.containsKey(column)) {
                max += map.get(column);
            }
        }
        return max;
    }
}
