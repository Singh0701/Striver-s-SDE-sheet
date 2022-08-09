import java.util.*;
public class Solution {
    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
    	int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            int[] current = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) current[j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if(i > 0) up += dp[j];
                    else up += 1e9;
                    if(j > 0) left += current[j - 1];
                    else left += 1e9;
                    current[j] = Math.min(up, left);
                }
            }
            dp = current;
        }
        return dp[n - 1];
    }
    
//     public static int solve(int i, int j, int[][] grid, int[][] dp) {
//         if(i == 0 && j == 0) return grid[i][j];
//         if(i < 0 || j < 0) return (int)1e9;
//         if(dp[i][j] != 0) return dp[i][j];
//         int up = grid[i][j] + solve(i - 1, j, grid, dp);
//         int left = grid[i][j] + solve(i, j - 1, grid, dp);
//         return dp[i][j] = Math.min(up, left);
//     }
}
