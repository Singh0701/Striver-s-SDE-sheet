import java.util.*;
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        //Previous row to compute current in loop below.
        int[] next = new int[n];
        
        //Fill in the prev with base case values.
        for(int j = 0; j < n; j++) {
            next[j] = triangle[n - 1][j];
        }
        for(int i = n - 2; i >= 0; i--) {
            int[] current = new int[n];
            for(int j = i; j >= 0; j--) {
                    int down = triangle[i][j] + next[j];
                    int diagonal = triangle[i][j] + next[j + 1];
                    current[j] = Math.min(down, diagonal);
                }
                next = current;
            }
        return next[0];
    } 
}
