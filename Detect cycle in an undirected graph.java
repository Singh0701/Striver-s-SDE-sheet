//BFS

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


//DFS  


class Solution {
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!visited[i]) {
                if(dfs(i, -1, adj, visited)) return true;
            }
        return false;
    }
    
    public boolean dfs(int sr, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[sr] = true;
        for(int n: adj.get(sr)) {
            if(!visited[n]) {
                if(dfs(n, sr, adj, visited))
                    return true;
            } else if(n != parent) return true;
        }
        return false;
    }
}
