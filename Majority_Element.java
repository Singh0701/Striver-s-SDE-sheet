// Problem Statement
// You have been given an array/list 'ARR' consisting of 'N' integers. Your task is to find the majority element in the array. If there is no majority element present, print -1.
// Note:
// A majority element is an element that occurs more than floor('N' / 2) times in the array.
    

// Sample Input 1:
// 2
// 5
// 2 3 9 2 2
// 4
// 8 5 1 9 
// Sample Output 1:
// 2
// -1
// Explanation of Sample Output 1:
// In test case 1, frequencies of occurrences of different elements are:

// 2 → 3 times
// 3 → 1 time
// 9 → 1 time

// As 2 occurs more than floor(5/2) (i.e. floor(2.5) = 2) times, it is the majority element.

// In test case 2, frequencies of occurrences of different elements are:

// 8 → 1 time
// 5 → 1 time
// 1 → 1 time
// 9 → 1 time

// As no element occurs more than floor(4/2) = 2 times. Thus No majority element is present.    
    
//Solution:

//Approach 1: Using Map, we will keep track of frequency of each element and while doing so if we encounter an element with frequency strictly greater than N/2 then we return it else retrun -1 at the end (As tyere's no element in the array with frequency greater than N/2).
    
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
        //Create an HashMap to keep frequencies of array's elements.
		HashMap<Integer, Integer> map = new HashMap<>();
        //Iterate over to count frequencies.
        for(int i: arr) {
            //Check if the element if already present in the HashMap then increment it's value by 1 else put into HashMap with value 1.
            map.put(i, map.getOrDefault(i, 0) + 1);
            //Check if the current element has frequency greater than N/2 then return it.
            if(map.get(i) > n/2)
                return i;
        }
        //Return -1 if we haven't find any element satisfying the given condition.
        return -1;
	}
}


//Time complexity = O(N)
//Space complexity = O(N)
