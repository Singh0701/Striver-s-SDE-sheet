// Problem Statement: Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

// Example 1:

// Input:
// N = 4
// M = 3
// E = 5
// Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
// Output: 1
// Explanation: It is possible to colour the
// given graph using 3 colours.
// Example 2:

// Input:
// N = 3
// M = 2
// E = 3
// Edges[] = {(0,1),(1,2),(0,2)}
// Output: 0
// Your Task:
// Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
// Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

// Expected Time Complexity: O(MN).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 ≤ N ≤ 20
// 1 ≤ E ≤ (N*(N-1))/2
// 1 ≤ M ≤ N

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        return colorGraph(0, m, n, graph, new int[n]);
    }
    
    public boolean colorGraph(int node, int colors, int nodes, boolean[][] graph, int[] color) {
        //Base case, If we are able color till the last node then it means it is possible to color graph with atmost m colors so we'll return true.
        if(node == nodes) {
            return true;
        }
        //Trying all the colors on the current node.
        for(int i = 1; i <= colors; i++) {
            //Check if it is valid to put ith color on node, if yes then color the node then make recursion call onto the next node.
            if(isValid(graph, node, i, color)) {
                color[node] = i;
                if(colorGraph(node + 1, colors, nodes, graph, color)) return true;
                //Remove the color while backtracking.
                color[node] = 0;
            }
        }
        //If we couldn't find any color to fill node as valid one then return false.
        return false;
    }
    
    
    //Utility  function to check if the given color is valid for node.
    public boolean isValid(boolean[][] graph, int node, int c, int[] color) {
        //Check for all it's adjacent nodes if they have same color or not.
        for(int i = 0; i < graph[node].length; i++) {
            if(graph[node][i] && color[i] == c) return false;
        }
        return true;
    }
}


//Time complexity = O(N^M)
//Space Complexity = O(N + N) - One N is for colors array and another N for stack space req. for the recursion calls.

