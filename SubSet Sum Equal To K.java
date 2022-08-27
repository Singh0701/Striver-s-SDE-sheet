//Approach 1: Recursion.
import java.util.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return checkSum(n - 1, arr, k);
    }
    public static boolean checkSum(int index, int[] arr, int sum) {
        if(sum == 0) return true;
        if(index == 0) return (sum == 0);
        boolean take = (arr[index] <= sum) ? checkSum(index - 1, arr, sum - arr[index]): false;
        boolean notTake = checkSum(index - 1, arr, sum);
        return take || notTake;
    }
}

//Approach 2: Memoization.
import java.util.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[1001][1001];
        for(int[] row: dp)        
            Arrays.fill(row, -1);
        return checkSum(n - 1, arr, k, dp);
    }
    public static boolean checkSum(int index, int[] arr, int sum, int[][] dp) {
        if(sum == 0) return true;
        if(index == 0) return (sum == 0);
        if(dp[index][sum] != -1) return dp[index][sum] == 0 ? false : true;
        boolean take = (arr[index] <= sum) ? checkSum(index - 1, arr, sum - arr[index], dp): false;
        boolean notTake = checkSum(index - 1, arr, sum, dp);
        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}


//Approach 3: Tabulation.

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k + 1];
        //Base case, when sum is 0.
        for(int i = 0; i < n; i++) 
            dp[i][0] = true;
        //Base case, when index is 0 and arr[0] is equal to sum.
        if(arr[0] < k) dp[0][arr[0]] = true;
        
        for(int i = 1; i < n; i++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if(arr[i] <= target) take = dp[i - 1][target - arr[i]];
                dp[i][target] = take || notTake;
            }
        }
        return dp[n - 1][k];
    }
}


//Space Optimized.

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] dp = new boolean[k + 1];
        //Base case, when sum is 0.
        dp[0] = true;
        //Base case, when index is 0 and arr[0] is equal to sum.
        if(arr[0] < k) dp[arr[0]] = true;
        for(int i = 1; i < n; i++) {
            boolean[] current = new boolean[k + 1];
            current[0] = true;
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[target];
                boolean take = false;
                if(arr[i] <= target) take = dp[target - arr[i]];
                current[target] = take || notTake;
            }
            dp = current;
        }
        return dp[k];
    }
}

