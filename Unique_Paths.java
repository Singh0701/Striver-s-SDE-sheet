// Problem Statement
// You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].
// To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].
    
    
// Sample Input 1:
// 2
// 3 2
// 1 6
// Sample Output 1:
// 3
// 1
// Explanation Of Sample Output 1:
// In test case 1, we are given a 3 x 2 matrix, to move from matrix[0][0] to matrix[2][1] we have the following possible paths.

// Path 1 = (0, 0) -> (0, 1) -> (1, 1) -> (2, 1)
// Path 2 = (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)
// Path 3 =  (0, 0) -> (1, 0) -> (1, 1) -> (2, 1)

// Hence a total of 3 paths are available, so the output is 3.

// In test case 2, we are given a 1 x 6 matrix, hence we just have a single row to traverse and thus total path will be 1.
    
 
// Solution:

// Approach 1: Recursive approach, here we recall the uniquePaths function for each, a down step (m -1) and right step (n - 1) and check with the base condition if we reach at (1,1) means it's one of the possible path so we increment the path count by returning 1.

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int uniquePaths(int m, int n) {
        //Base condition for destination (1,1).
        if(m == 1 && n == 1)
            return 1;
        //if any of the coordinates are neagtive means, it's an invalid path so return 0.
        if(m < 0 || n < 0) 
            return 0;
        //Recursive call for down and right step.
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

// Time complexity = exponential 
// Space complexity = recursion stack memory usage in exponential terms.
    
// Approach 2: In above approach we'll use the memoization with recursion and solve it in Polynomial time.

import java.util.* ;
import java.io.*; 
public class Solution {
    //Initialize the dp array with size 16 x 16 as per the given constraint.
    static int[][] dp = new int[16][16];
	public static int uniquePaths(int m, int n) {
        //Base condition for destination (1,1).
        if(m == 1 && n == 1)
            return 1;
        //if any of the coordinates are neagtive means, it's an invalid path so return 0.
        if(m < 0 || n < 0) 
            return 0;
        //Check if we already computed total unique paths for (m,n) in dp array. if yes then return it without computing again.
        if(dp[m][n] != 0)
            return dp[m][n];
        //If not computed earlier then compute it and save in dp array for further use.
        dp[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        //return the final answer that is stored at (m,n) in the dp array.
        return dp[m][n];
	}
}

// Time complexity = O(n * m)
// Space complexity = O(n * m) 
