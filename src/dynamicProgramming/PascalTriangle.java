package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle?envType=problem-list-v2&envId=2lhxgujc
 */
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> nums = generate(5);
        for (List<Integer> num : nums) {
            for (Integer i : num) {
                System.out.print(i);
            }
            System.out.println("\n");

        }
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = result.get(i - 1);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prev.get(j) + prev.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}

/**
 * Row 1:        [1]
 * Row 2:       [1, 1]
 * Row 3:      [1, 2, 1]
 * Row 4:     [1, 3, 3, 1]
 * Row 5:    [1, 4, 6, 4, 1]
 */