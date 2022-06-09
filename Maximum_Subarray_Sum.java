// Problem Statement
// You are given an array (ARR) of length N, consisting of integers. You have to find the sum of the subarray (including empty subarray) having the maximum sum among all subarrays.
// A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or more integers from the beginning, and 0 or more integers from the end of an array.
// Note: The sum of an empty subarray is 0.
    
// Sample Input 1 :
// 9
// 1 2 7 -4 3 2 -10 9 1
// Sample Output 1 :
// 11
// Explanation For Sample 1 :
// The subarray yielding maximum sum is [1, 2, 7, -4, 3, 2].
   
// Solution: 

// Approach 1: Using kadane's algorithm, here we keep track of a sum variable in which we'll keep on adding up the current element and check for two conditions that are if the sum is greater than maxSum then update maxSum, and if the sum < 0 then set sum = 0 (Because we are trying to maximize the sum, hence we don't need a sub-array whose contribution is negative to the sub-array sum). And the end we'll be left with the Maximum possible sum of a subarray.
    
    
import java.util.*;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0, sum = 0; //Initializing sum and maxSum to zero.
        //Iterating over the array.
        for(int i: arr) {
            //Add current element to sum.
            sum += i; 
            //Check if the sum is greater then maxSum, if yes, then update the value,
            if(sum > maxSum)
                maxSum = sum;
            //If the sum is going in negative then set it to zero.
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
	}
}

// TIme complexity = O(N);
// Space complexity = O(1);
