// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        //Check first and last row for 'O's.
        for(int col = 0; col < m; col++) {
            //First row.
            if(board[0][col] == 'O' && !visited[0][col]) {
                dfs(0, col, board, visited, dx, dy);
            }
            //Last row.
            if(board[n - 1][col] == 'O' && !visited[n - 1][col]) {
                dfs(n-1, col, board, visited, dx, dy);
            }
        }
        
        //Check first and last col for 'O's.
        for(int row = 0; row < n; row++) {
            //First col.
            if(board[row][0] == 'O' && !visited[row][0]) {
                dfs(row, 0, board, visited, dx, dy);
            }
            //Last col.
            if(board[row][m - 1] == 'O' && !visited[row][m - 1]) {
                dfs(row, m - 1, board, visited, dx, dy);
            }
        }
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(!visited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }
    
    public void dfs(int row, int col, char[][] board, boolean[][] visited, int[] dx, int[] dy) {
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(isValid(newRow, newCol, board, visited)) {
                dfs(newRow, newCol, board, visited, dx, dy);
            }
        }
    }
    
    public boolean isValid(int row, int col, char[][] board, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;
        return (row < n && col < m && row >= 0 && col >= 0 && !visited[row][col] && board[row][col] == 'O');
    }
}



//Time complexity = O(N+M) * 2 + O(N*M)
//Space complexity = O(N*M)
