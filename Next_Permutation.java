// Problem Statement
// You have been given a permutation of ‘N’ integers. A sequence of ‘N’ integers is called a permutation if it contains all integers from 1 to ‘N’ exactly once. Your task is to rearrange the numbers and generate the lexicographically next greater permutation.
// To determine which of the two permutations is lexicographically smaller, we compare the first elements of both permutations. If they are equal — compare the second, and so on. If we have two permutations X and Y, then X is lexicographically smaller if X[i] < Y[i], where ‘i’ is the first index in which the permutations X and Y differ.
    
// For example, [2, 1, 3, 4] is lexicographically smaller than [2, 1, 4, 3].
    
// Solution:

// Approach 1: Generating all the possible dictionary permutations and returning the next one, if no next is present then the 1st permutation or just the reverse of the last one. This will have exponential space and time complexity, not going to implement. We will move on to the optimal approach discussed below.
    
    
// Approach 2: In this approach, we will use the peak point of a permutation to get the next one, that is all the DICTIONARY permutations will have an increasing peak followed by a decreasing one (Assume the last element as a peak if no greater element is present) so with help of this first we will traverse the array from backward and see for a breakpoint that right after the peak value, and save that index of the breakpoint. 
// ***    
// Edge case: If in the first iteration, we couldn't find any breakpoint that means the given permutation is the last one from its dictionary orders. In this case, reverse (sort) the array and return it.    
// ***
// Now in another backward traversal of the array will try to find the element which greater than the element at the breakpoint index and swap both of them, now we can see that we have removed the existing breakpoint by swapping the elements so what that means is now we just need the smallest dictionary order in the right half of the new peak value (that is the breakpoint index), that's basically an increasing order of elements in the right half. (Reverse the array from breakpoint index + 1 to array length - 1).

    
    
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		int index = permutation.size() - 1;
        //First while loop to find the breakpoint as discussed above.
        while(index > 0) {
            //If found the desired breakpoint, then terminate the loop.
            if(permutation.get(index - 1) < permutation.get(index)) 
                break;
            index--;
        }
        //Edge case: If the breakpoint is not present in the array, then reverse the ArrayList and return answer.
        if(index == 0) {
            //Calling the helper function to reverse the ArrayList.
            reverse(permutation, index, permutation.size()  - 1);
            return permutation;
        }
        int index_2 = permutation.size()  - 1;
        //Now as we found an breakpoint, we will again traverse from the backwards and look for the elements greater than the breakpoint element and swap both followed by reverse of the right half part (index + 1, array length - 1).
        while(index_2 > 0) {
            //Check If element if greater than breakpoint.
            if(permutation.get(index_2) > permutation.get(index - 1)) {
                //Swap the elements.
                swap(permutation, index_2, index - 1);
                //Reverse the ArrayList.
                reverse(permutation, index, permutation.size()  - 1);
                break;
            }
            index_2--;
        }
        //Return the answer;
        return permutation;
	}
    
    //Helper function to swap two elements in ArrayList.
    public static void swap(ArrayList<Integer> permutation, int left, int right) {
        int temp = permutation.get(left);
        permutation.set(left, permutation.get(right));
        permutation.set(right, temp);
    }
    
    //Helper function to reverse an ArrayList for the given left and right index bound.
    public static void reverse(ArrayList<Integer> permutation, int left, int right) {
        while(left < right) {
            swap(permutation, left++, right--);
        }
    }
    
}


// Time complexity = O(N + N);
// Space complexity = O(1);
