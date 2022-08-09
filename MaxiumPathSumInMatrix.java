import java.util.*;
public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //Take a previous array.
		int[] prev = new int[n];
        //Recursion with memoization.
//         int max = Integer.MIN_VALUE;        
//         for(int j = 0; j < n; j++) {
//             max = Math.max(f(m - 1, j, matrix, dp), max);
//         }
//         return max;
        
        //Fill up the previous array with base case values.
        for(int j = 0; j < n; j++) 
            prev[j] = matrix[0][j];
        //Start calculating from 1st row, as 0th row is already been taken care of with base case.
        for(int i = 1; i < m; i++) {
            //Take a current row that we'll compute using the previous row and then make previous refrencing to current row.
            int[] current = new int[n];
            for(int j = 0; j < n; j++) {
                    int up = matrix[i][j] + prev[j];
                    int leftDiagonal= matrix[i][j];
                    if(j-1>=0) leftDiagonal += prev[j-1];
                //if(going out of bound means the current path is invalid so assign it a big negative value to avoid considering it in final count).
                    else leftDiagonal += (int)Math.pow(-10,9);
                    int rd = matrix[i][j];
                    if(j + 1 < n) rd += prev[j + 1];
                    else rd += (int)Math.pow(-10,9);
                //Store the max of all three into the current's jth column.
                    current[j] = Math.max(up, Math.max(leftDiagonal, rd));
            }
            //Assign current to previous.
            prev = current;
        }
        //Find max.
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++)
            max = Math.max(prev[j], max);
        return max;
	}
    
    //DP Memoization function code.
    public static int f(int i, int j, int[][] matrix, int[][] dp) {
        if(j < 0 || j >= matrix[0].length) return (int)-1e9;
        if(i == 0) return matrix[i][j];
        if(dp[i][j] > 0) return dp[i][j];
        int up = matrix[i][j] + f(i - 1, j, matrix, dp);
        int ld = matrix[i][j] + f(i - 1, j - 1, matrix, dp);
        int rd = matrix[i][j] + f(i - 1, j + 1, matrix, dp);
        return dp[i][j] = Math.max(up, Math.max(ld, rd));
    }
}
