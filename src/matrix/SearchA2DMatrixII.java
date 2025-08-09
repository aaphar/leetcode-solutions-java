package matrix;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] arr = {{-1, 3}};
        searchMatrix(arr, 3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c -= 1;
            } else {
                r += 1;
            }
        }

        return false;
    }
}
