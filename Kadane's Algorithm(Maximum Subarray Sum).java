//Brute Force.

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int curr = 0;
                for(int k = i; k <= j; k++) {
                    curr += nums[k];
                }
                maxSum = Math.max(curr, maxSum);
            }
        }
        return maxSum;
    }
}

//Time complexity = O(N^3)
//Space complexity = O(1)


//Better Approach:

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int curr = 0;
            for(int j = i; j < n; j++) {
                curr += nums[j];
                maxSum = Math.max(curr, maxSum);
            }
        }
        return maxSum;
    }
}

//Time complexity = O(N^2)
//Space complexity = O(1)

import java.util.*;
import java.io.*; 

public class Solution {
    
    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = arr[0], sum = 0; //Initializing sum to zero and maxSum to first element as we have to take atleast one element in consideration.
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


//Time complexity = O(N)
//Space complexity = O(1)
