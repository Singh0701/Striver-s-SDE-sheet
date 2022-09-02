//Recursion.
public class Solution {
    public static int findWays(int num[], int tar) {
        return countSubSets(num.length - 1, num, tar);
    }
    public static int countSubSets(int index, int[] num, int target) {
        if(index == 0) {
            return (target == num[0]) || target == 0 ? 1 : 0;
        }
        int notPick = countSubSets(index - 1, num, target);
        int pick = (num[index] <= target) ? countSubSets(index - 1, num, target - num[index]) : 0;
        return notPick + pick;
    }
}

//Memoization.

import java.util.*;
public class Solution {
    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for(int[] row: dp) 
            Arrays.fill(row, -1);
        return countSubSets(num.length - 1, num, tar, dp);
    }
    public static int countSubSets(int index, int[] num, int target, int[][] dp) {
        if(index == 0) {
            return (target == num[0]) || target == 0 ? 1 : 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = countSubSets(index - 1, num, target, dp);
        int pick = (num[index] <= target) ? countSubSets(index - 1, num, target - num[index], dp) : 0;
        return dp[index][target] = notPick + pick;
    }
}

//Tabulation.
import java.util.*;
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        
        int[] prev = new int[tar + 1];
        
        prev[0] = 1;
        
        if(num[0] <= tar) 
            prev[num[0]] = 1;
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[tar + 1];
            curr[0] = 1;
            for(int target = 0; target <= tar; target++) {
                int notPick = prev[target];
                int pick = (num[i] <= target) ? prev[target - num[i]] : 0;
                curr[target] = pick + notPick;
            }
            prev = curr;
        }
        return prev[tar];
    }
}
