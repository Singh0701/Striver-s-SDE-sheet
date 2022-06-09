//Problem Statement
//You have been given an integer array/list(ARR) of size 'N'. It only contains 0s, 1s, and 2s. Write a solution to sort this array/list.

//Example:
// Sample Input 1 :
// 2
// 6
// 0 1 2 2 1 0
// 7
// 0 1 2 1 2 1 2
// Sample Output 1 :
// 0 0 1 1 2 2
// 0 1 1 1 2 2 2
// Solution:

// Approach 1: Use three variables zero, one, and two to count the occurrences of each 0s, 1s, and 2s. And then filling the array with 0s followed 
// by 1s and 2s.

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int zero = 0, one = 0, two = 0;
        //Iterate over array and count occurrences of each 0, 1 and 2.
        for(int i: arr) {
            if(i == 0)
                zero++;
            else if(i == 1)
                one++;
            else if(i == 2)
                two++;
        }
        int index = 0;
        //Run while loops for each 0, 1 and 2. and fill the array.
        while(zero-- > 0) 
            arr[index++] = 0;
        while(one-- > 0) 
            arr[index++] = 1;
        while(two-- > 0) 
            arr[index++] = 2;
    }
}

// Time complexity = O(N + N)
// Space Complexity = O(1)


// Approach 2: Dutch national flag algorithm to sort in one iteration. (Three pointer approach).

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int low = 0, mid = 0, high = arr.length - 1;
        while(mid <= high) {
            //If mid value is 0 then we swap with it's correct position that is low, and increment boht mid and low.
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                mid++; 
                low++;
            }
            //If the mid value is 1 then we do nothing just increment the mid variable.
            else if(arr[mid] == 1) {
                mid++;
            }
            //if we encounter an 2 at mid then we swap with high and decrement high variable.
            else if(arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Time complexity = O(N)
// Space Complexity = O(1)
