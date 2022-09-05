class Solution
{
    class Pair {
        int row;
        int col;
        int distance;
        Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distances = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        bfs(grid, distances, visited);
        return distances;
    }
    
    public void bfs(int[][] grid, int[][] distances, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i1 = 0; i1 < size; i1++) {
                Pair node = queue.poll();
                int row = node.row;
                int col = node.col;
                int distance = node.distance;
                distances[row][col] = distance;
                for(int i = 0; i < 4; i++) {
                    int nRow = row + dx[i];
                    int nCol = col + dy[i];
                    if(isValid(nRow, nCol, visited)) {
                        queue.add(new Pair(nRow, nCol, distance + 1));
                        visited[nRow][nCol] = true;
                    }
                }
            }
        }
    }
    
    public boolean isValid(int i, int j, boolean[][] visited) {
        return (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && !visited[i][j]);
    }
}

//Time complexity = O(N*M + N*M)
//Space complexity = O(N*M)
