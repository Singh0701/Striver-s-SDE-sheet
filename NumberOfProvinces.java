// Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. 
// Your task is to find the number of provinces.Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.
Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    
//Solution: 
    
//Approach 1: Using Breadth First Search Algorithm.    

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int N) {
        int count = 0;
        //Taking an visited array.
        boolean[] visited = new boolean[N];
        //Going through the given Adjacency Matrix and look if there is a connection betwen two vertex and if not visited then call a bfs traversal on that node.
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                if(adj.get(i).get(j) == 1 && !visited[j]) {
                    //The above if condition will be true only when we enter a new Province hence increment the count variable and perform bfs.
                    count++;
                    bfs(i, adj, visited);
                }
            }
        }
        return count;
    }
    
    //BFS Traversal.
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i = 0; i < adj.get(current).size(); i++)
                if(adj.get(current).get(i) == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
        }
    }
};


// Space Complexity = O(N)
// Time Complexity = O(N^2) + O(2 * E)
// N -> No. of nodes.
// E -> No. of edges.


//Approach 2: Using Depth First Search Algorithm (Recursive).    


class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int N) {
        int count = 0;
        //Taking an visited array.
        boolean[] visited = new boolean[N];
        //Going through the given Adjacency Matrix and look if there is a connection betwen two vertex and if not visited then call a bfs traversal on that node.
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                if(adj.get(i).get(j) == 1 && !visited[j]) {
                    //The above if condition will be true only when we enter a new Province hence increment the count variable and perform bfs.
                    count++;
                    dfs(i, adj, visited);
                }
            }
        }
        return count;
    }
    
    //DFS Traversal.
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++) {
            if(!visited[i] && adj.get(node).get(i) == 1) {
                dfs(i, adj, visited);
            }
        }
    }
    

// Space Complexity = O(N + N)
// Time Complexity = O(N) + O(V + E)
// N -> No. of nodes.
// E -> No. of edges.
