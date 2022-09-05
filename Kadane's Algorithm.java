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
//Space complexity = O(N)
