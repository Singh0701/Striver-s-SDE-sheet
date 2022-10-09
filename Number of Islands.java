//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> result = new ArrayList<Integer>();
        int[][] graph = new int[rows][cols];
        for(int[] row: operators) {
            graph[row[0]][row[1]] = 1;
            int size = 0;
            boolean[][] visited = new boolean[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(!visited[i][j] && graph[i][j] == 1) {
                        size++;
                        visited[i][j] = true;
                        dfs(i, j, graph, visited);
                    }
                }
            }
            result.add(size);
        }
        return result;
    }
    
    public void dfs(int i, int j, int[][] graph, boolean[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[i][j] = true;
        for(int index = 0; index < 4; index++) {
            int newI = i + dx[index];
            int newJ = j + dy[index];
            if(isValid(newI, newJ, graph) && graph[newI][newJ] == 1 && !visited[newI][newJ]) {
                dfs(newI, newJ, graph, visited);
            }
        }
    }
    
    public boolean isValid(int i, int j, int[][] graph) {
        return (i < graph.length && i >= 0 && j < graph[0].length && j >= 0);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
