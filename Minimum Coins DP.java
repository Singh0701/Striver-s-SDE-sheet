//Approach 1: Using recursion, try out all the possible combinations.

public class Solution {
    public static int minimumElements(int num[], int x) {
        int ans = minimumCoins(num.length - 1, num, x);
        //If there's no such combination to make upto target then the recursive function would be returning a int max value so if tthat's the case then we return -1, else return the answer.
        return (ans >= (int) 1e9) ? -1 : ans;  
    }
    
    public static int minimumCoins(int index, int[] coins, int target) {
        //Base case, we are left with only one coin so if it's multiple of remaining target then take it or else return a big value.
        if(index == 0) {
            return (target % coins[0] == 0) ? target/coins[0] : (int) 1e9;
        }
        //Take current coin if it is less than or equal to target and add one + call function and stay at the same index.
        int take = (int) 1e9;
        if(coins[index] <= target) take = 1 + minimumCoins(index, coins, target - coins[index]);
        //If not taking current coin then move to next.
        int notTake = minimumCoins(index - 1, coins, target);
        //Return minimum of both.
        return Math.min(take, notTake);
    }
}

//Time complexity is exponential > 2^n.
//Space complexity is exponential as well > 2^n.


//Approach 2: Memoization.

import java.util.*;

public class Solution {
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        //Create a dp array to memoize the overlapping sub problems.
        int[][] dp = new int[n][x + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int ans = minimumCoins(num.length - 1, num, x, dp);
        //If there's no such combination to make upto target then the recursive function would be returning a int max value so if that's the case then we return -1, else return the answer.
        return (ans >= (int) 1e9) ? -1 : ans;  
    }
    
    public static int minimumCoins(int index, int[] coins, int target, int[][] dp) {
        //Base case, we are left with only one coin so if it's multiple of remaining target then take it or else return a big value.
        if(index == 0) {
            return (target % coins[0] == 0) ? target/coins[0] : (int) 1e9;
        }
        //Take current coin if it is less than or equal to target and add one + call function and stay at the same index.
        //If already computed then return.
        if(dp[index][target] != -1) return dp[index][target];
        int take = (int) 1e9;
        if(coins[index] <= target) take = 1 + minimumCoins(index, coins, target - coins[index], dp);
        //If not taking current coin then move to next.
        int notTake = minimumCoins(index - 1, coins, target, dp);
        //Return minimum of both.
        return dp[index][target] = Math.min(take, notTake);
    }
}


//Time complexity = O(N * T)
//Space complexity = O(N * T) + O(T)

//Approach 3: Tabulation.

import java.util.*;

public class Solution {
    public static int minimumElements(int coins[], int x) {
        int n = coins.length;
        //Create a dp array to memoize the overlapping sub problems.
        int[][] dp = new int[n][x + 1];
        //Base case
        for(int i = 0; i <= x; i++) 
            dp[0][i] = (i % coins[0] == 0) ? i/coins[0] : (int) 1e9;
        
        for(int index = 1; index < n; index++) {
            for(int target = 0; target <= x; target++) {
                int take = (int) 1e9;
                if(coins[index] <= target) take = 1 + dp[index][target - coins[index]];
                //If not taking current coin then move to next.
                int notTake = dp[index - 1][target];
                //Return minimum of both.
                dp[index][target] = Math.min(take, notTake);    
            }
        }
        //If there's no such combination to make upto target then we get a int max value so if that's the case then we return -1, else return the answer.
        return (dp[n - 1][x] >= (int) 1e9) ? -1 : dp[n - 1][x];  
    }
}


//Time complexity = O(N * T)
//Space complexity = O(N * T) 



//Approach 4: Tabulation (Space optimized).

import java.util.*;

public class Solution {
    public static int minimumElements(int coins[], int x) {
        int n = coins.length;
        //Create a dp array to memoize the overlapping sub problems.
        int[] prev = new int[x + 1];
        //Base case
        for(int i = 0; i <= x; i++) 
            prev[i] = (i % coins[0] == 0) ? i/coins[0] : (int) 1e9;
        
        for(int index = 1; index < n; index++) {
            int[] curr = new int[x + 1];
            for(int target = 0; target <= x; target++) {
                int take = (int) 1e9;
                if(coins[index] <= target) take = 1 + curr[target - coins[index]];
                //If not taking current coin then move to next.
                int notTake = prev[target];
                //Return minimum of both.
                curr[target] = Math.min(take, notTake);    
            }
            prev = curr;
        }
        //If there's no such combination to make upto target then we get a int max value so if that's the case then we return -1, else return the answer.
        return (prev[x] >= (int) 1e9) ? -1 : prev[x];  
    }
}

//Time complexity = O(N * T)
//Space complexity = O(T) 

