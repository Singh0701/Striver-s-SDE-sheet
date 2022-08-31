//Approach 1: Using Recursion.

public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
        //Calculate the sum for given array, assume it to be the subset 1 which has all the elements initially.
        int sum = 0;
        for(int i: arr) sum += i;
        //Call the function which return the Min abs difference.
		    return f(n - 1, arr, sum, 0);
	}
    public static int f(int index, int[] arr, int sum1, int sum2) {
        //Base case when reach starting end of the array, return the abs difference of sum1 and sum2 which is sum of subset 1 and subset 2 respectively.
        if(index < 0) return Math.abs(sum1 - sum2);
        //Take =  recursion call to consider current index element into the subset 2 and remove from subset 1.
        int take = f(index - 1, arr, sum1 - arr[index], sum2 + arr[index]);
        //Not take = recursion call to not consider the current index element into the subset 2.
        int notTake = f(index - 1, arr, sum1, sum2);
        //Return minimum of both.
        return Math.min(take, notTake);
    }
}



//Approach 2: Using Tabulation and intuition from the problem subset sum equals.
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for(int i: arr) sum += i;
		boolean[] prev = new boolean[sum + 1];
        if(arr[0] <= sum) prev[arr[0]] = true;
        for(int i = 1; i < n; i++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for(int j = 1; j <= sum; j++) {
                boolean take = (j >= arr[i]) ? prev[j - arr[i]] : false;
                boolean notTake = prev[j];
                curr[j] = take || notTake;
            }
            prev = curr;
        }
        int min = (int) 1e18;
        for(int i = 0; i <= sum; i++) {
            if(prev[i]) {
                min = Math.min(min, Math.abs(i - (sum - i)));
            }
        }     
        return min;
	}
    public static int f(int index, int[] arr, int sum1, int sum2) {
        if(index < 0) return Math.abs(sum1 - sum2);
        int take = f(index - 1, arr, sum1 - arr[index], sum2 + arr[index]);
        int notTake = f(index - 1, arr, sum1, sum2);
        return Math.min(take, notTake);
    }
}

