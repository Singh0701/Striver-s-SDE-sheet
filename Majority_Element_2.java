// Problem Statement
// You are given an array/list 'ARR' of integers of length ‘N’. You are supposed to find all the elements that occur strictly more than floor(N/3) times in the given array/list.
    
// Sample Input 1 :
// 2
// 7
// 3 2 2 1 5 2 3
// 5
// 7 4 4 9 7
// Sample Output 1:
// 2
// 4 7
// Explanation Of Sample Input 1:
// In the first test case, floor(N/3) = floor(7/3) is equal to 2, and 2 occurs 3 times which is strictly more than N/3. No other element occurs more than 2 times.

// In the second test case, floor(N/3) = floor(5/3) is equal to 1, and 4 and 7 both occur 2 times. No other element occurs more than once.
    
    
// Solution:

// Approach 1: Using HashMap, will first iterate over the ArrayList and count the frequency of each element, and then using another for loop will iterate for all the Key values from the map's keySet() values to avoid redundancy and put them into the result ArrayList if the current element's frequency is strictly greater than N (N = (floor) ArrayList size / 3).

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        //Getting the N/3 floor value.
        int N = arr.size()/3;
        //Creating a HashMap to keep track of the frequency of integer elements.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //Iterating through the array, and add/update it's frequency count.
        for(int i: arr) {
            //Check if the element if already present in the HashMap then increment it's value by 1 else put into HashMap with value 1.
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //Clear the ArrayList to store the result.
        arr.clear();
        //Iterate over all the Key values of the HashMap.
        for(int i: map.keySet()) {
            //If the the current Key/Element has frequency is strictly greater than N then add it into the ArrayList.
            if(map.get(i) > N) {
                arr.add(i);
            }
        }
        //Return the final result.
        return arr;
    }
}

//Time Complexity = O(N + N) 
//Space Complexity = O(N)
