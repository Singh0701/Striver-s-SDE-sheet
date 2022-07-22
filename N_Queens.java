// Problem Statement: The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:


// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] c: board)
            Arrays.fill(c, '.');
        boolean[] left = new boolean[n], upperDiagonal = new boolean[2*n - 1], lowerDiagonal = new boolean[2*n - 1];
        solve(0, result, board, n, left, upperDiagonal, lowerDiagonal);
        return result;
    }
    
    public void solve(int col, List<List<String>> result, char[][] board, int n, boolean[] left, boolean[] upperDiagonal , boolean[] lowerDiagonal) {
      //Checking for the base case, If the board is filled upto the (n-1)th column then add it to the List.
        if(col == n) {
            result.add(new ArrayList<>());
          //Converting to string.
            StringBuilder sb = new StringBuilder();
            for(char[] c: board) {
                for(char cc: c) 
                    sb.append(cc);
                result.get(result.size() - 1).add(sb.toString());
                sb = new StringBuilder();
            }
            return;
        }
      
      //For the current col, checkk for all the rows from 0 to n-1 if a Queen can be placed or not and then make a recursion call for next column.
        for(int row = 0; row < n; row++) {
          //Checking if the current (row, col) position is safe for a new Queen to place.
            if(!left[row] && !lowerDiagonal[row + col] && !upperDiagonal[n-1 + col - row]) {
              //Set the rows, and both diagonals to true so that no other queen can be placed in them.
              left[row] = lowerDiagonal[row + col] = upperDiagonal[n-1 + col - row] = true;
              //Place the queen.
              board[row][col] = 'Q';
              //Make a recursion call.
              solve(col + 1, result, board, n, left, upperDiagonal, lowerDiagonal);
              //Remove the queen while backtracking.
              board[row][col] = '.';
              //Make the spot available for other queens.
              left[row] = lowerDiagonal[row + col] = upperDiagonal[n-1 + col - row] = false;
            }
        }
    }
}


//TIme Complexity = O(N! * N)
//Space Complexity = O(N)
