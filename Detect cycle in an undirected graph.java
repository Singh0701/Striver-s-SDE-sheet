//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    //Pair class to store Node and Parent pairs in the Queue, while performing BFS Algorithm to detect cycles.
    class Pair {
        int node;
        int parent;
        Pair(int n, int p) {
            node = n;
            parent = p;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!visited[i]) {
                if(bfs(i, adj, visited)) return true;
            }
        return false;
    }
    
    public boolean bfs(int sr, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, -1));
        visited[sr] = true;
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int node = curr.node;
            int parent = curr.parent;
            for(int n: adj.get(node)) {
                if(!visited[n]) {
                    queue.add(new Pair(n, node));
                    visited[n] = true;
                } else if(n != parent) return true;
            }
        }
        return false;
    }
}
