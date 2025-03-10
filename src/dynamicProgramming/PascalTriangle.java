package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

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

    // TODO
    public List<List<Integer>> generateBetter(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            int ans = 1;
            temp.add(ans);
            for (int j = 1; j < i; j++) {
                ans = ans * (i - j);
                ans = ans / j;
                temp.add(ans);
            }
            res.add(temp);
        }
        return res;

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.getFirst().add(1);


        for (int i = 1; i < numRows; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> new_row = new ArrayList<>();

            new_row.add(1);
            for (int j = 1; j < prev_row.size(); j++) {
                new_row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
            new_row.add(1);
            triangle.add(new_row);

        }


        return triangle;
    }
}

/**
 * Row 1:        [1]
 * Row 2:       [1, 1]
 * Row 3:      [1, 2, 1]
 * Row 4:     [1, 3, 3, 1]
 * Row 5:    [1, 4, 6, 4, 1]
 *
 *
 */