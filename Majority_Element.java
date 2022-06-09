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

//Approach 1: Using Map, we will keep track of the frequency of each element and while doing so if we encounter an element with a frequency strictly greater than N/2 then we return it else return -1 at the end (As there's no element in the array with a frequency greater than N/2).
    
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
        //Return -1 if we haven't found any element satisfying the given condition.
        return -1;
	}
}


//Time complexity = O(N)
//Space complexity = O(N)


//Approach 2: Using Boyer-Moore Majority Voting Algorithm. Here we take two variables count and majorityElement and initialize with 0, now linearly traverse the array, check for the following condition:
// if count is equal to 0 then set majorityElement to current element.
// if the currenet element is equal to majorityElement then increment count by 1.
// else decrement the count by 1.
// At the end of the loop we will be left with the majority element in the array into majorityElement variable.


import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMajority(int[] arr, int n) {
        //Create and initialize count and majorityElement to 0.
        int count = 0, majorityElement = 0;
        //Iterate over to count frequencies.
        for(int i: arr) {
            //if count is 0 then set majorityElement to i.
            if(count == 0)
                majorityElement = i;
            //if the majorityElement is equal to i then increment count by 1.
            if(majorityElement == i)    count++;
            //else decrement by 1.
            else count--;
        }
        //Return -1 if we haven't find any element satisfying the given condition.
        return -1;
    }
}


//Time complexity = O(N)
//Space complexity = O(1)



