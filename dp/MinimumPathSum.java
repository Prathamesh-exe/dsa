// https://leetcode.com/problems/minimum-path-sum/description/

import java.util.*;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(minPathSumTopDown(grid)); // Output: 7
        System.out.println(minPathSumBottomUp(grid)); // Output: 7
        System.out.println(minPathSumSpaceOptimized(grid)); // Output: 7
    }
   

    //time complexity: O(m*n)
    //space complexity: O(m*n) for dp array + O(m+n) for recursion stack
    private static int minPathSumTopDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumHelper(grid, 0, 0, dp);
    }

    private static int minPathSumHelper(int[][] grid, int i, int j, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: reached bottom-right cell
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Check if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move down and right
        int down = minPathSumHelper(grid, i + 1, j, dp);
        int right = minPathSumHelper(grid, i, j + 1, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }

    //time complexity: O(m*n)
    //space complexity: O(m*n)
    private static int minPathSumBottomUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j] represents minimum path sum to reach cell (i,j)
        int[][] dp = new int[m][n];

        // Initialize first cell
        dp[0][0] = grid[0][0];

        // Fill first row with only right moves
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]; // Only one way to reach cells in the first row
        }

        // Fill first column with only down moves
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];  // Only one way to reach cells in the first column
        }

        // Fill rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]); // Choose the minimum path from top(dp[i-1][j]) or left(dp[i][j-1])
            }
        }
        // The bottom-right cell contains the minimum path sum
        return dp[m - 1][n - 1];
    }
    
    //time complexity: O(m*n)
    //space complexity: O(n)
    private static int minPathSumSpaceOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[j] represents minimum path sum to reach cell in current row at column j
        int[] dp = new int[n];

        // Initialize first cell
        dp[0] = grid[0][0];

        // Fill first row with only right moves
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];// Only one way to reach cells in the first row
        }

        // Fill rest of the table
        // Iterate through each row starting from the second row
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // Update first column for current row (only down moves)
            // Update the rest of the columns
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);// Choose the minimum path from top(dp[j]) or left(dp[j-1])
            }
        }

        return dp[n - 1];// The last element contains the minimum path sum to reach bottom-right cell
    }

}
