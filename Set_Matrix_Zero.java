//Problem Statement: Given an ‘N’ x ‘M’ integer matrix, if an element is 0, set its entire row and column to 0's, and return the matrix. In particular, your task is to modify it in such a way that if a cell has a value 0 (matrix[i][j] == 0), then all the cells of the ith row and jth column should be 
// changed to 0 (You must do inplace).

// For Example:
// If the given grid is this:
// [7, 19, 3]
// [4, 21, 0]

// Then the modified grid will be:
// [7, 19, 0]
// [0, 0,  0]



// Solution:

// Approach 1: Using Extra space.

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        Set<Integer> rows = new HashSet<>(); //Creating Set to store the row number's, who's elements has to be set to zero.
        Set<Integer> cols = new HashSet<>(); //Creating Set to store the column number's, who's elements has to be set to zero.
        
        //Traversing the 2d array to check the presence of zero's in cells. and storing them in Set(s)
        for(int i = 0; i < matrix.length; i++)  {
            for(int j = 0; j < matrix[i].length; j++)  {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        //Iterating over all the rows from Set rows and set each cell of that row to zero. 
        for(int i: rows) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        
        //Iterating over all the rows from Set cols and set each cell of that column to zero. 
        for(int i: cols) {
            for(int j = 0; j < matrix.length; j++)
                matrix[j][i] = 0;
        }
    }
}



// Time Complexity = O((N * M) + R + C)
// Space Complexity = O(R + C)

// where N and M are numbers of rows and columns in the given array. 
// R and C is the number of rows and columns for which the elements will be set to zero.


// Approach 2: Constant space use. (In-place)
// In this approach instead of creating an array or Set, we'll be using the first row and column of the given 2d array itself to mark rows and columns 
// along with an boolean variable for the first column (Because we might set the first column elements to zero by the zeros for other rows and columns elements). 
// That is, while traversing (except first column) if we encounter an zero then we set it's 0th row and 0th column cell to 0 and for 0th column set Flag to true if matrix[i][0] is 0.
// Now traverse again from bottom right that is from end of the 2d array, see if for the element matrix[i][j] (j != 0) the matrix[i][0] is 0  or matrix[0][j] is 0 then set matrix[i][j] to zero. and for column 0 
// check if flag is true set matrix[i][0] to 0.

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        Boolean col1 = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0)
                col1  = true; //Set flag for column 1
            //Loop starting from 1st column, not 0th as we have the aboove if condition to deal with 0th column's element.
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0; //Set the 0th row and 0th coluumn to zero.
            }
        }
        for(int i = matrix.length -1; i >= 0; i--) {
            for(int j = matrix[i].length -1; j > 0; j--) {
                //if row or column is marked then set matrix[i][j] to zero.
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j]= 0;
            }
            //if col1 flag is true then set it's element to zero.
            if(col1)
                matrix[i][0] = 0;
        }
    }
}

// Time Complexity = O((N * M) + (N * M))
// Space Complexity = O(1)
// where N and M are numbers of rows and columns in the given array. 
