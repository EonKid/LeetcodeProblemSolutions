package com.dns.dsalgoconcepts;

/**
 * 
 * 
 * Backtracking pseudocode
bool Solve(configuration conf)
{
   if (no more choices)     // BASE CASE
         return (conf is goal state);
   for (all available choices) {
       try one choice c;
         // solve from here, if works out, you're done
       if (Solve(conf with choice c made)) return true;
       unmake choice c;
    }
return false; // tried all choices, no soln found }

Time Complexity: O(N!), where N is the size of the chessboard (number of rows/columns).

Space Complexity: O(N^2 + N)
The recursive call stack depth is at most N, corresponding to the number of rows on the chessboard.
Therefore, the overall space complexity is O(N^2 + N), which simplifies to O(N^2).
 * 
 */
public class NQueens {

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (solveNQueensUtil(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveNQueensUtil(int[][] board, int col, int numberOfQueens) {
    	
    	if (col == numberOfQueens) {
			return true;
		}
    	
    	for (int rowToTry = 0; rowToTry < numberOfQueens; rowToTry++) {
			if (isSafe(board, rowToTry, col, numberOfQueens)) {
				board[rowToTry][col] = 1;
				if (solveNQueensUtil(board, col+1, numberOfQueens)) {
					return true;
				}
				board[rowToTry][col] = 0;
			}
		}
    	
    	return false;

    }

    private static boolean isSafe(int[][] board, int row, int col, int numberOfQueens) {
     
    	//check rows
    	for (int j = 0; j < col; j++) {
			if (board[row][j] == 1) {
				return false;
			}
		}
    	
    	// check upper left
    	for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
    	
    	// lower left
    	for (int i = row, j = col; i < numberOfQueens && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
    	
    	return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1) ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2; // You can change the value of 'n' to solve the problem for different board sizes
        solveNQueens(n);
    }
}

