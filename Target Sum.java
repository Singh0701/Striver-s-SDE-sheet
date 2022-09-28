//Problem Statement: We are given an array ‘ARR’ of size ‘N’ and a number ‘Target’. Our task is to build an expression from the given array where we can place a ‘+’ or ‘-’ sign in front of an integer. We want to place a sign in front of every integer of the array and get our required target. We need to count the number of ways in which we can achieve our required target.

//Recursion:

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	return countWays(n - 1, arr, target);
    }
    
    public static int countWays(int index, int[] arr, int target) {
        if(index < 0) return (target == 0) ? 1 : 0;
        //Here for each index we have two options, either add or subtract.
        int add = countWays(index - 1, arr, target + arr[index]);
        int sub = countWays(index - 1, arr, target - arr[index]);
        return add + sub;
    }
}

//Time complexity = O(2^N)
//Space complexity = O(N)
