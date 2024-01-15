package com.dns.dsalgo.recursionbacktracking;

/**
 * The time and space complexity of the Sudoku Solver program using backtracking can be analyzed as follows:

Time Complexity: O(9^(n^2))
The time complexity of the backtracking algorithm for solving Sudoku is generally exponential.
In the worst case, the algorithm explores all possible combinations of numbers in each empty cell until a solution is found.
The exact time complexity is hard to express precisely, but it can be approximated as O(9^(n^2)), where n is the size of the Sudoku grid (9 in the case of a standard 9x9 Sudoku).

Space Complexity:O(n^2)
The space complexity is determined by the recursion stack during the backtracking process.
In the worst case, the maximum depth of the recursion stack is proportional to the number of empty cells in the Sudoku grid.
The space complexity is O(n^2), where n is the size of the Sudoku grid.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudokuGrid = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(sudokuGrid)) {
            System.out.println("Sudoku solved successfully:");
            printSudoku(sudokuGrid);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
    }

    private static boolean solveSudoku(int[][] grid) {
        int[] emptyCell = findEmptyCell(grid);

        // If there are no empty cells, the Sudoku is solved
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        // Try placing digits from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                // Place the digit if it's safe
                grid[row][col] = num;

                // Recur to solve the rest of the puzzle
                if (solveSudoku(grid)) {
                    return true;
                }

                // If placing the digit didn't lead to a solution, backtrack
                grid[row][col] = 0;
            }
        }

        // No digit can be placed, backtrack to the previous state
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check if 'num' is not present in the current row, column, and 3x3 grid
        return !usedInRow(grid, row, num) &&
               !usedInColumn(grid, col, num) &&
               !usedInBox(grid, row - row % 3, col - col % 3, num);
    }

    private static boolean usedInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInColumn(int[][] grid, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInBox(int[][] grid, int startRow, int startCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] findEmptyCell(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null; // No empty cell found
    }

    private static void printSudoku(int[][] grid) {
        for (int[] row : grid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

