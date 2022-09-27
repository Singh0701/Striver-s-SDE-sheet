// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        boolean[][] visited = new boolean[n][m];
        //Traverse first and last row.
        for(int j = 0; j < m; j++) {
            if(!visited[0][j] && a[0][j] == 'O')
                    dfs(0, j, a, visited, n, m);
            if(!visited[n - 1][j] && a[n - 1][j] == 'O') 
                    dfs(n - 1, j, a, visited, n, m);
        }
        
        //First and last column.
        for(int i = 0; i < n; i++) {
            if(!visited[i][0] && a[i][0] == 'O')
                    dfs(i, 0, a, visited, n, m);
            if(!visited[i][m - 1] && a[i][m - 1] == 'O') 
                    dfs(i, m - 1, a, visited, n, m);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) 
                    a[i][j] = 'X';
            }
        }
        return a;
    }
    
    static void dfs(int row, int col, char[][] a, boolean[][] visited, int n, int m) {
        visited[row][col] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int i = 0; i < 4; i++) {
            int nRow = row + dx[i];
            int nCol = col + dy[i];
            if(isValid(nRow, nCol, n, m) && a[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                dfs(nRow, nCol, a, visited, n, m);
            }
        }
    }
    static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}



//Time complexity = O(N+M) * 2 + O(N*M)
//Space complexity = O(N*M)
