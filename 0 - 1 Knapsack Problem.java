//Approach 1: Recursion.

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         return getMax(n - 1, wt, val, W);
    } 
    
    static void getMax(int index, int[] wt, int[] val, int W) {
        if(index < 0) {
            return 0;
        }
        int take = (wt[index] <= W) ? val[index] + getMax(index - 1, wt, val, W - wt[index]) : 0;
        int notTake = getMax(index - 1, wt, val, W);
        return Math.max(take, notTake);
    }
}


//Time complexity = O(2^n)
//Space complexity = O(N)


//Approach 2: Memoization.

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[][] dp = new int[n][W + 1];
         for(int[] row: dp) Arrays.fill(row, -1);
         getMax(n - 1, wt, val, W, dp);
         return dp[n - 1][W];
    } 
    
    static int getMax(int index, int[] wt, int[] val, int W, int[][] dp) {
        if(index == 0) {
            return (wt[index] <= W) ? val[0] : 0;
        }
        if(dp[index][W] != -1) return dp[index][W];
        int pick = (wt[index] <= W) ? val[index] + getMax(index - 1, wt, val, W - wt[index], dp) : 0;
        int notPick = getMax(index - 1, wt, val, W, dp);
        return dp[index][W] = Math.max(pick, notPick);
    }
}

//Time complexity = O(N * W)
//Space complexity = O(N + N * W)



//Approach 3: Tabulation.

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[][] dp = new int[n][W + 1];
         for(int j = wt[0]; j <= W; j++) {
             dp[0][j] = val[0];
         }
         
         for(int index = 1; index < n; index++) {
             for(int weight = 0; weight <= W; weight++) {
                int pick = (wt[index] <= weight) ? val[index] + dp[index - 1][weight - wt[index]] : Integer.MIN_VALUE;
                int notPick = dp[index - 1][weight];
                dp[index][weight] = Math.max(pick, notPick);
             }
         }
         return dp[n - 1][W];
    } 
}

//Time complexity = O(N * W)
//Space complexity = O(N * W)


//Space Optimized to two rows.

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[] dp = new int[W + 1];
         for(int j = wt[0]; j <= W; j++) {
             dp[j] = val[0];
         }
         
         for(int index = 1; index < n; index++) {
             int[] curr = new int[W + 1];
             for(int weight = 0; weight <= W; weight++) {
                int pick = (wt[index] <= weight) ? val[index] + dp[weight - wt[index]] : Integer.MIN_VALUE;
                int notPick = dp[weight];
                curr[weight] = Math.max(pick, notPick);
             }
             dp = curr;
         }
         return dp[W];
    } 
}


//Time complexity = O(N * W)
//Space complexity = O(W + W)



//Space Optimized to one row.

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[] dp = new int[W + 1];
         for(int j = wt[0]; j <= W; j++) {
             dp[j] = val[0];
         }
         for(int index = 1; index < n; index++) {
             int[] curr = new int[W + 1];
             for(int weight = W; weight >= 0; weight--) {
                int pick = (wt[index] <= weight) ? val[index] + dp[weight - wt[index]] : Integer.MIN_VALUE;
                int notPick = dp[weight];
                dp[weight] = Math.max(pick, notPick);
             }
         }
         return dp[W];
    } 
}


//Time complexity = O(N * W)
//Space complexity = O(W)
