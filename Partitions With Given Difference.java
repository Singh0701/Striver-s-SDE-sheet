//Recursion.

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int sum1 = 0;
        //Computing and storing the sum of all elements into sum1 which represents the first partition's sum.
        for(int i: arr)
            sum1 += i;
        //Calling the recursive function to try out all the possible subsets for the second partition and count the no. of partitions that satisfies the condition (sum1 >= sum2 && abs(sum1 - sum2) == D).
        return count(n - 1, arr, sum1, 0, d);
	}
    
    public static int count(int index, int[] arr, int sum1, int sum2, int d) {
        //Base case
        if(sum2 > sum1) return 0;
        if(index < 0) {
            return (sum1 >= sum2 && Math.abs(sum1 - sum2) == d) ? 1 : 0;
        }
        //Now you have two options for the current index, one is to pick and add it into the partition two and at same time remove from the first partition OR Not pick the current index and move to next.
        int notPick = count(index - 1, arr, sum1, sum2, d);
        int pick = (sum2 + arr[index] > sum1) ? 0 : count(index - 1, arr, sum1 - arr[index], sum2 + arr[index], d);
        return notPick + pick;
    }
}


//Recursion 2: 

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int sum1 = 0;
        //Computing and storing the sum of all elements into sum1 which represents the first partition's sum.
        for(int i: arr)
            sum1 += i;
        //Calling the recursive function to try out all the possible subsets for the second partition and count the no. of partitions that satisfies the condition (sum1 >= sum2 && abs(sum1 - sum2) == D).
        return count(n - 1, arr, sum1, 0, d);
	}
    
    public static int count(int index, int[] arr, int sum1, int sum2, int d) {
        //Base case
        if(index < 0) {
            return (sum1 >= sum2 && Math.abs(sum1 - sum2) == d) ? 1 : 0;
        }
        //Now you have two options for the current index, one is to pick and add it into the partition two and at same time remove from the first partition OR Not pick the current index and move to next.
        int notPick = count(index - 1, arr, sum1, sum2, d);
        int pick = (sum2 + arr[index] > sum1) ? 0 : count(index - 1, arr, sum1 - arr[index], sum2 + arr[index], d);
        return notPick + pick;
    }
}


//Memoization: 


import java.util.*;
public class Solution {
    static int mod =(int)(Math.pow(10,9)+7);

	public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for(int i: arr) total += i;
 
        if((total - d) % 2 == 1 || (total - d) < 0) return 0;
        int target = (total - d) / 2;       
        
        int[][] dp = new int[n][(target) + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        subsets(n - 1, arr, target, dp);
		return dp[n - 1][target];
	}
    public static int subsets(int index, int[] arr, int target, int[][] dp) {
        if(index == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int pick = (arr[index] <= target) ? subsets(index - 1, arr, target - arr[index], dp) : 0;
        int notPick = subsets(index - 1, arr, target, dp);
        return dp[index][target] = (pick + notPick) % mod;
    }
}



//Tabulation.


import java.util.*;
public class Solution {
    static int mod =(int)(Math.pow(10,9)+7);

	public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for(int i: arr) total += i;
        if((total - d) % 2 == 1 || (total - d) < 0) return 0;
        int target = (total - d) / 2;       
        
        int[][] dp = new int[n][(target) + 1];
        
        for(int sum = 0; sum <= target; sum++) {
            if(sum == 0 && arr[0] == 0)
                dp[0][sum] = 2;
            else if(sum == 0 || sum == arr[0]) 
                dp[0][sum] = 1;
            else dp[0][sum] = 0;
        }
        
        for(int index = 1; index < n; index++) {
            for(int sum = 0; sum <= target; sum++) {
                int pick = (arr[index] <= sum) ? dp[index - 1][sum - arr[index]] : 0;
                int notPick = dp[index - 1][sum];
                dp[index][sum] = (pick + notPick) % mod;
            }
        }
		return dp[n - 1][target];
	}
}

/Time Complexity = O(N*Target)
//Spcae Complexity = O(N*Target)


//Space Optimization:


import java.util.*;
public class Solution {
    static int mod =(int)(Math.pow(10,9)+7);

	public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for(int i: arr) total += i;
        if((total - d) % 2 == 1 || (total - d) < 0) return 0;
        int target = (total - d) / 2;       
        
        int[] prev = new int[(target) + 1];
        
        for(int sum = 0; sum <= target; sum++) {
            if(sum == 0 && arr[0] == 0)
                prev[sum] = 2;
            else if(sum == 0 || sum == arr[0]) 
                prev[sum] = 1;
            else prev[sum] = 0;
        }
        
        for(int index = 1; index < n; index++) {
            int[] curr = new int[target + 1];
            for(int sum = 0; sum <= target; sum++) {
                int pick = (arr[index] <= sum) ? prev[sum - arr[index]] : 0;
                int notPick = prev[sum];
                curr[sum] = (pick + notPick) % mod;
            }
            prev = curr;
        }
		return prev[target];
	}
}



/Time Complexity = O(N*Target)
//Spcae Complexity = O(Target)
