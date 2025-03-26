package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] arr = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(isValidSudoku(arr));

    }

    // Time complexity O(1), we always iterate through 81 cells
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0' - 1;
                int boxIndex = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || sub[boxIndex][num]) {
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                sub[boxIndex][num] = true;
            }
        }
        return true;
    }

    public boolean isValidSudokuStringSolution(char[][] board) {
        Set<String> seem = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char element = board[i][j];
                if (element != '.') {
                    if (seem.contains(element + "row" + i)
                            || seem.contains(element + "column" + j)
                            || seem.contains(element + "box" + i / 3 + "x" + j / 3)
                    ) {
                        return false;
                    }
                    seem.add(element + "row" + i);
                    seem.add(element + "column" + j);
                    seem.add(element + "box" + i / 3 + "x" + j / 3);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuBoxIssueNotWorking(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> column = new HashSet<>();
        Set<Character> subBox = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // check if there is any duplicate in the row board[i][j]
                if (Character.isDigit(board[i][j])) {
                    if (row.contains(board[i][j])) {
                        return false;
                    }

                    if (Math.abs(i / 3 - j / 3) < 3) {
                        if (subBox.contains(board[i][j])) {
                            return false;
                        }
                        subBox.add(board[i][j]);
                    }

                    row.add(board[i][j]);
                }

                // check if there is any duplicate in the column board[j][i]
                if (Character.isDigit(board[j][i])) {
                    if (column.contains(board[j][i])) {
                        return false;
                    }
                    if (i / 3 == j / 3) {
                        if (i != j && subBox.contains(board[j][i])) {
                            return false;
                        }
                        subBox.add(board[j][i]);
                    }
                    column.add(board[j][i]);
                }
            }
        }
        return true;
    }
}

/**
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */