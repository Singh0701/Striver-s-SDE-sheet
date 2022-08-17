// Problem Description: 

// We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it, mat[i][j] gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1). Both of them can move only to the cells below them in these three directions: to the bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

// When Alica and Bob visit a cell, they take all the chocolates from that cell with them. It can happen that they visit the same cell, in that case, the chocolates need to be considered only once.

// They cannot go out of the boundary of the given matrix, we need to return the maximum number of chocolates that Bob and Alice can together collect.

// Example:

// Solution :

import java.util.*;

public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
		int[] dj = {-1, 0, +1};
        for(int j1 = 0; j1 < c; j1++) {
            for(int j2 = 0; j2 < c; j2++) {
                dp[r - 1][j1][j2] = (j1 == j2) ? grid[r - 1][j1] : grid[r - 1][j1] + grid[r - 1][j2];
            }
        }
        for(int i = r - 2; i >= 0; i--) {
            for(int j1 = c - 1; j1 >= 0; j1--) {
                for(int j2 = c - 1; j2 >= 0; j2--) {
                    int maxi = (int) -1e8;
                    for(int dj1: dj) {
                        for(int dj2: dj) {
                            int value = 0;
                            value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            if(j1 + dj1 >= 0 && j2 + dj2 >= 0 && j1 + dj1 < c && j2 + dj2 < c) 
                                value += dp[i+1][j1 + dj1][j2 + dj2];
                            else value = (int)-1e8;
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }    
            }
        }
        return dp[0][0][c - 1];
    }
}


// Time Complexity: O(N*M*M)*9
// Space Complexity: O(N*M*M)
