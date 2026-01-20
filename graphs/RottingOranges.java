
import java.util.*;

// https://leetcode.com/problems/rotting-oranges/

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(grid));

    }
    private static int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // Add rotten oranges to the queue
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0; // No fresh oranges to rot
        if (queue.isEmpty()) return -1; // No rotten oranges to start the process

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            
            // Process all rotten oranges in the current minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();
                int r = current[0];//row of current orange
                int c = current[1];//column of current orange

                // Check all 4 directions
                int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    // If the adjacent cell is a fresh orange, rot it
                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the orange
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }   

        return freshOranges == 0 ? minutes : -1;
}
}
