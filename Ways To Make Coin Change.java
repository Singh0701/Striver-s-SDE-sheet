//Recursion: 

public class Solution {

	public static long countWaysToMakeChange(int coins[], int value){
        return countWays(coins.length - 1, coins, value);
	}
	public static long countWays(int index, int[] coins, int value) {
        if(index == 0) return (value % coins[0] == 0 || value == 0) ? 1 : 0;
        long pick = (coins[index] <= value) ? countWays(index, coins, value - coins[index]) : 0;
        long notPick = countWays(index - 1, coins, value);
        return pick + notPick;
    }
}


//Time complexity = Exponential
//Space complexity = O(Target)



//Memoization:

import java.util.*;

public class Solution {
	public static long countWaysToMakeChange(int coins[], int value){
        int n = coins.length;
        long[][] dp = new long[n][value + 1];
        for(long[] row: dp) Arrays.fill(row, -1);
        return countWays(n - 1, coins, value, dp);
	}
	public static long countWays(int index, int[] coins, int value, long[][] dp) {
        if(index == 0) return (value % coins[0] == 0 || value == 0) ? 1 : 0;
        if(dp[index][value] != -1) return dp[index][value];
        long pick = (coins[index] <= value) ? countWays(index, coins, value - coins[index], dp) : 0;
        long notPick = countWays(index - 1, coins, value, dp);
        return dp[index][value] = pick + notPick;
    }
}


//Time complexity = O(Target * N)
//Space complexity = O(Target) + O(Target * N)



//Tabulation: 

import java.util.*;
public class Solution {
	public static long countWaysToMakeChange(int coins[], int value){
        int n = coins.length;
        long[][] dp = new long[n][value + 1];
        for(int sum = 0; sum <= value; sum++) {
            if(sum % coins[0] == 0) dp[0][sum] = 1;
        }
        
        for(int index = 1; index < n; index++) {
            for(int sum = 0; sum <= value; sum++) {
                long pick = (coins[index] <= sum) ? dp[index][sum - coins[index]] : 0;
                long notPick = dp[index - 1][sum];
                dp[index][sum] = pick + notPick;
            }
        }
        return dp[n - 1][value];
	}
}

//Time complexity = O(Target * N)
//Space complexity = O(Target * N)


//Space optimized:


import java.util.*;
public class Solution {
	public static long countWaysToMakeChange(int coins[], int value){
        int n = coins.length;
        long[] prev = new long[value + 1];
        for(int sum = 0; sum <= value; sum++) {
            if(sum % coins[0] == 0) prev[sum] = 1;
        }
        
        for(int index = 1; index < n; index++) {
            long[] curr = new long[value + 1];
            for(int sum = 0; sum <= value; sum++) {
                long pick = (coins[index] <= sum) ? curr[sum - coins[index]] : 0;
                long notPick = prev[sum];
                curr[sum] = pick + notPick;
            }
            prev = curr;
        }
        return prev[value];
	}
}

//Time complexity = O(Target * N)
//Space complexity = O(Target)
