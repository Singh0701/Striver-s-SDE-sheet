// Problem Statement
// Ninja has been given two sorted integer arrays/lists ‘ARR1’ and ‘ARR2’ of sizes ‘M’ and ‘N’. Ninja has to merge these sorted arrays/lists into ‘ARR1’ as one sorted array. You may have to assume that ‘ARR1’ has a size equal to ‘M’ + ‘N’ such that ‘ARR1’ has enough space to add all the elements of ‘ARR2’ in ‘ARR1’.
    
// For example:
// ‘ARR1’ = [3 6 9 0 0]
// ‘ARR2’ = [4 10]
// After merging the ‘ARR1’ and ‘ARR2’ in ‘ARR1’. 
// ‘ARR1’ = [3 4 6 9 10]

// Solution:

// Approach 1: Using the sorting algorithm. storing the arr2 elements in arr1's extra space given and then applying a sort function or sorting algorithm to sort.
    
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        for(int i = m; i < (m + n); i++) {
            arr1[i] = arr2[i - m];
        }
        Arrays.sort(arr1);
        return arr1;
    }
}

// Tme comlexity = O(N * Log(N) + N )
// Space complexity = O(N);

// Approach 2: Optimal approach using the GAP method. Here we calculate the gap value by diving the total length by 2 (Ceil value if it's odd and not equal to 1), Enter a while loop while the gap value is greater than 0, inside which we'll take two pointers pointer1 at 0 and pointer2 at gap value, another while loop, while the pointer2 is less than the array length. if the condition element at pointer1 is greater than pointer2 then swap both, and keep incrementing pointers. After the inner loop terminates then recalculate the gap value by dividing by 2. At the end of the outer loop will get the sorted array.


import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        //Storing array 2 elements in array 1.
        for(int i = m; i < (m + n); i++) {
            arr1[i] = arr2[i - m];
        }
        //Initial gap value.
        int gap = (m + n) / 2;
        //If odd then increment gap to get the ceil value. OR Can use Math.ceil() function by passing in double values.
        if((m + n) % 2 != 0) gap++;
        //Outer loop while gap value is greater than 0.
        while(gap > 0) {
            //Set Pointer 1 to zero and 2 to gap.
            int pointer_1 = 0;
            int pointer_2 = gap;
            //Inner loop while the pointer 2 is less than (m + n).
            while(pointer_2 < (m + n)) {
                //If pointer 1 values greater than pointer 2 then swap them.
                if(arr1[pointer_1] > arr1[pointer_2]) {
                    swap(arr1, pointer_1 , pointer_2);
                }
                //Keep incrementing the poniters.
                pointer_1++; pointer_2++;
            }
            //Recalculate the gap value.
            if(gap > 2 && gap % 2 != 0) gap++;
            gap /= 2;
        } 
        return arr1;
    }
    
    //Utility function for swapping elements in an array.
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    
}
                                                                                                                
// Tme comlexity = O(N * Log(N))
// Space complexity = O(1);                                                                                                                
