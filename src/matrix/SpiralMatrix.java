package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
    public static void main(String[] args) {
//        [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int bottom = matrix.length, right = matrix[0].length;
        int top = 0, left = 0;

        while (bottom > top && left < right) {
            int j = left;

            while (j < right) {
                list.add(matrix[top][j]);
                j++;
            }
            top++;


            int i = top;

            while (i < bottom) {
                list.add(matrix[i][right - 1]);
                i++;
            }
            right--;


            j = right - 1;
            if (top < bottom) {
                while (j >= left) {
                    list.add(matrix[bottom - 1][j]);
                    j--;
                }
                bottom--;
            }

            i = bottom - 1;
            if (left < right) {
                while (i >= top) {
                    list.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        return list;
    }
}
