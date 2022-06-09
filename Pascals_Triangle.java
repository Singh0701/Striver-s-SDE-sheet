// Problem Statement
// You are given an integer N. Your task is to return a 2-D ArrayList containing the pascal’s triangle till the row N.
// A Pascal's triangle is a triangular array constructed by summing adjacent elements in preceding rows. Pascal's triangle contains the values of the binomial coefficient. For example in the figure below.
    
// For example, given integer N= 4 then you have to print.
// 1  
// 1 1 
// 1 2 1 
// 1 3 3 1

// Here for the third row, you will see that the second element is the summation of the above two-row elements i.e. 2=1+1, and similarly for row three 3 = 1+2 and 3 = 1+2.
 
// Solution: 

// Approach 1: We'll create a 2d ArrayList and initially we add the first row and create a previous row variable that will point to the previous row. Then we run a loop for each row from 1 to N-1, create a new ArrayList as the current row we are computing, and inside which another loop to add a total of i + 1 elements (where i is the row number, the ith row would have i + 1 elements in it). for first and last column we'll add 1 (if j == i OR j == 0) and for rest, we'll make use of the Previous row and access it's (j - 1) + jth element. At the end of each iteration of the inner loop, we'll update the previous row as the current one and add current to our final result.
    
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
            //Final resultant ArrayList we'll be returning.
            ArrayList<ArrayList<Long>> result = new ArrayList<>();
            //Previous row variable.
            ArrayList<Long> prev = new ArrayList<>();
            //Initializing 1st row with 1, and setting previous to row 1.
            prev.add((long) 1);
            result.add(prev);
            //Loop to fill the pascal triangle from 2nd row onwards, as we have already added the 1st row above.
            for(int i = 1; i < n; i++) {
                //Creating the current row to be added in the pascal triangle.
                ArrayList<Long> current = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                   //If it is the first or last column of the row then fill it with 1.
                   if(j == 0 || j == i)
                       current.add((long) 1);
                   //Else, to fill the values otherthen first and last column, we'll use the previous row with sum of element present at it's j'th and j-1 index.
                   else
                       current.add((long) (prev.get(j - 1) + prev.get(j)));
                }
                //Add the current row to the final result. and then set the previous row to the current row.
                result.add(current);
                prev = current;
            }
            //Return the pascal triangle.
            return result;
	}
}

// Time Complexity = O(N^2)
// Space Complexity = O(N^2)
