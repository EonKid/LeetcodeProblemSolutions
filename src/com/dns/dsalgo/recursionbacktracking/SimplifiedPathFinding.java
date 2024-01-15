package com.dns.dsalgo.recursionbacktracking;

/**
 * 

The time and space complexity of the provided recursive backtracking solution for the Simplified Path Finding Problem is as follows:

Time Complexity: O(2^(N^2))
In the worst case, the algorithm needs to explore all possible paths from the source to the destination.
The number of possible paths is exponential, as there are 2^(N^2) possible paths, where N is the size of the matrix (assuming an N x N matrix).
Therefore, the time complexity is exponential, O(2^(N^2)).

Space Complexity:O(N^2)
The space complexity is determined by the recursion stack and the additional space used for the boolean matrix to track visited cells.
The maximum depth of the recursion stack is at most N^2 (the size of the matrix), as each cell can be visited only once.
The space complexity is O(N^2) due to the recursion stack and the boolean matrix.
Optimization:
The exponential time complexity indicates that the algorithm may be impractical for large matrices. 
One potential optimization is to use dynamic programming to memoize results and avoid redundant computations.
 */

public class SimplifiedPathFinding {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1}
        };

        if (findPath(matrix)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path exists.");
        }
    }

    private static boolean findPath(int[][] matrix) {
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        return findPathUtil(matrix, 0, 0, visited);
    }

    private static boolean findPathUtil(int[][] matrix, int row, int col, boolean[][] visited) {
    	int n = matrix.length;
    	
    	//base case
    	if (row < 0 || col < 0 || row >= n || col >= n || matrix[row][col] == 0 || visited[row][col]) {
			return false;
		}
    	
    	visited[row][col] = true;
    	
    	if (row == n - 1 && col == n - 1) {
			return true;
		}
    	
    	if (findPathUtil(matrix, row + 1, col, visited) || findPathUtil(matrix, row, col+1, visited)) {
			return true;
		}
    	
    	visited[row][col] = false;
    	
    	return false;
    }
}

