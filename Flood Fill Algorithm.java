// Problem Statement: An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

// Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

// To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

// Example 1:

// Input: image = {{1,1,1},{1,1,0},{1,0,1}},
// sr = 1, sc = 1, newColor = 2.
// Output: {{2,2,2},{2,2,0},{2,0,1}}
// Explanation: From the center of the image 
// (with position (sr, sc) = (1, 1)), all 
// pixels connected by a path of the same color
// as the starting pixel are colored with the new 
// color.Note the bottom corner is not colored 2, 
// because it is not 4-directionally connected to 
// the starting pixel.

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int initialColor = image[sr][sc];
        //di and dj to help out in exploriing all 4 directions without writing a line for each direction.
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int n = image.length;
        int m = image[0].length;
        //Create a copy of image to preserve the original input data.
        int[][] copy = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy[i][j] = image[i][j];
            }
        }
        //Call the DFS function on copy of image from (sr,sc).
        dfs(sr, sc, copy, initialColor, newColor, new boolean[n][m], di, dj);
        return copy;
    }
    
    public void dfs(int i, int j, int[][] image, int ic, int nc, boolean[][] visited, int[] di, int[] dj) {
        //IF indices goes out of bound then return.
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length) return;
        //if the color of current pixel is same as the initial color and it's not already visited then fill it with new color, mark visited, and explore all of it's 4 directions.
        if(image[i][j] == ic && !visited[i][j]) {
            image[i][j] = nc;
            visited[i][j] = true;
            for(int index = 0; index < 4; index++)
                dfs(i + di[index], j + dj[index], image, ic, nc, visited, di, dj);
        }
    }
}
