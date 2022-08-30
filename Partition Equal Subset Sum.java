//Approach 1: Recursion.

public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
        for(int i: arr) sum += i;
        if(sum % 2 != 0) return false;
        else sum = sum / 2;
        return subsetSum(n - 1, arr, sum);
	}
    
    public static boolean subsetSum(int index, int[] arr, int sum) {
        if(sum == 0) return true;
        if(index == 0) return arr[0] == sum;
        boolean pick = (arr[index] <= sum) ? subsetSum(index - 1, arr, sum - arr[index]) : false;
        boolean notPick = subsetSum(index - 1, arr, sum);
        return pick || notPick;
    }
}


//Approach 2: Memoization.
import java.util.*;

public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
        for(int i: arr) sum += i;
        if(sum % 2 != 0) return false;
        else sum = sum / 2;
        int[][] dp = new int[n][sum + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return subsetSum(n - 1, arr, sum, dp);
	}
    
    public static boolean subsetSum(int index, int[] arr, int sum, int[][] dp) {
        if(sum == 0) return true;
        if(index == 0) return arr[0] == sum;
        if(dp[index][sum] != -1) return dp[index][sum] == 1;
        boolean pick = (arr[index] <= sum) ? subsetSum(index - 1, arr, sum - arr[index], dp) : false;
        boolean notPick = subsetSum(index - 1, arr, sum, dp);
        dp[index][sum] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }
}


//Approach 3: Tabulation.


import java.util.*;

public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
        for(int i: arr) sum += i;
        if(sum % 2 != 0) return false;
        else sum = sum / 2;
        //DP Array
        boolean[][] dp = new boolean[n][sum + 1];
        //Base cases
        for(int i = 0; i < n; i++)
            dp[i][0] = true;
        if(arr[0] <= sum)
            dp[0][arr[0]] = true;
        //Filling the DP Array
        for(int index = 1; index < n; index++) {
            for(int target = 1; target <= sum; target++) {
                boolean pick = (arr[index] <= target) ? dp[index - 1][target - arr[index]] : false;
                boolean notPick = dp[index - 1][target];
                dp[index][target] = (pick || notPick);
            }
        }        
        return dp[n - 1][sum];
	  }
}


//Approach 4: Space Optimization

import java.util.*;

public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
        for(int i: arr) sum += i;
        if(sum % 2 != 0) return false;
        else sum = sum / 2;
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if(arr[0] <= sum)
            prev[arr[0]] = true;
        for(int index = 1; index < n; index++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for(int target = 1; target <= sum; target++) {
                boolean pick = (arr[index] <= target) ? prev[target - arr[index]] : false;
                boolean notPick = prev[target];
                curr[target] = (pick || notPick);
            }
            prev = curr;
        }        
        return prev[sum];
	}
}
