// Problem Statement
// You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.
// Note:
// Each pair should be sorted i.e the first value should be less than or equal to the second value. 

// Return the list of pairs sorted in non-decreasing order of their first value. In case if two pairs have the same first value, the pair with a smaller second value should come first.
    
// Sample Input 1:
// 5 5
// 1 2 3 4 5
// Sample Output 1:
// 1 4
// 2 3
// Explaination For Sample Output 1:
// Here, 1 + 4 = 5
//       2 + 3 = 5
// Hence the output will be, (1,4) , (2,3).
    
    
// Solution:

// Approach 1: Brute force approach, first sorting the given array and then finding all such pairs whose sum is equal to the target sum. and storing it in the ArrayList as arrays are not dynamic in Java, then once we found all such pairs we create a 2d array of the same size as ArrayList and 2 columns, store all pairs in an array and return it.
   

import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == s) {
                    first.add(arr[i]);
                    second.add(arr[j]);
                }
            }
        }
        int[][] result = new int[first.size()][2];
        for(int i = 0; i < first.size(); i++) {
            result[i][0] = first.get(i);
            result[i][1] = second.get(i);
        }
        return result;
    }
}



// Time complexity = O((N^2 + N*log(N)))
// Space Complexity = O(N + N + 2*N)
