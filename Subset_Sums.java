//Problem Statement: Given a list arr of N integers, print sums of all subsets in it.

// Example 1:

// Input:
// N = 2
// arr[] = {2, 3}
// Output:
// 0 2 3 5
// Explanation:
// When no elements is taken then Sum = 0.
// When only 2 is taken then Sum = 2.
// When only 3 is taken then Sum = 3.
// When element 2 and 3 are taken then 
// Sum = 2+3 = 5.



//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> sums = new ArrayList<>();
        getSum(0, arr, N, 0, sums);
        return sums;
    }
    
    public void getSum(int index, ArrayList<Integer> arr, int n, int sum, ArrayList<Integer> sums) {
        //If the index goes out of bound then just store the sum accumulated so far into the ArrayList, and return.
        if(index >= n) {
            sums.add(sum);
            return;
        }
        //First we'll make a recursion call that'll pick (consider) the current element.
        getSum(index + 1, arr, n, sum + arr.get(index), sums);
        //Second recursion call without picking the current element.
        getSum(index + 1, arr, n, sum, sums);
    }
}


//Time complexity = O(2^N)
//Space complexity = O(2^N)
