//Recursion:

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return knapsack(n - 1, w, profit, weight);
    }
    
    public static int knapsack(int index, int cap, int[] profit, int[] weight) {
        //base case
        if(index == 0) {
            if(cap == 0) return (int) -1e9;
            else return (cap >= weight[index]) ? (profit[index] * (cap / weight[index])) : 0;
        }
        //Explore all possibilities
        int pick = (cap >= weight[index]) ? profit[index] + knapsack(index, cap - weight[index], profit, weight) : 0;
        int notPick = knapsack(index - 1, cap, profit, weight);
        return Math.max(pick, notPick);
    }
}

//Time complexity = Exponential
//Space complexity = O(W)


//Memoization:

import java.util.* ;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return knapsack(n - 1, w, profit, weight, dp);
    }
    
    public static int knapsack(int index, int cap, int[] profit, int[] weight, int[][] dp) {
        //base case
        if(index == 0) {
            if(cap == 0) return (int) -1e9;
            else return (cap >= weight[index]) ? (profit[index] * (cap / weight[index])) : 0;
        }
        //Check if memoized already then return else continue.
        if(dp[index][cap] != -1) return dp[index][cap];
        //Explore all possibilities
        int pick = (cap >= weight[index]) ? profit[index] + knapsack(index, cap - weight[index], profit, weight, dp) : 0;
        int notPick = knapsack(index - 1, cap, profit, weight, dp);
        return dp[index][cap] = Math.max(pick, notPick);
    }
}


//Time complexity = O(N * W)
//Space complexity = O(W) + O(N * W)



//Tabulation: 


import java.util.* ;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int wt = 0; wt <= w; wt++) {
            dp[0][wt] = (wt >= weight[0]) ? (profit[0] * (wt / weight[0])) : 0;
        }
        dp[0][0] = (int) -1e9;
        
        for(int index = 1; index < n; index++) {
            for(int cap = 0; cap <= w; cap++) {
                int pick = (cap >= weight[index]) ? profit[index] + dp[index][cap - weight[index]]: 0;
                int notPick = dp[index - 1][cap];
                dp[index][cap] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][w];
    }
}


//Time complexity = O(N * W)
//Space complexity = O(N * W)


//Space optimized:


import java.util.* ;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];
        for(int wt = 0; wt <= w; wt++) {
            prev[wt] = (wt >= weight[0]) ? (profit[0] * (wt / weight[0])) : 0;
        }
        prev[0] = (int) -1e9;
        for(int index = 1; index < n; index++) {
            int[] curr = new int[w+1];
            for(int cap = 0; cap <= w; cap++) {
                int pick = (cap >= weight[index]) ? profit[index] + curr[cap - weight[index]]: 0;
                int notPick = prev[cap];
                curr[cap] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[w];
    }
}

//Time complexity = O(N * W)
//Space complexity = O(W)
