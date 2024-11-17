import java.util.*; 
public class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] inRec = new boolean[V];
        
        for (int i = 0; i < V; i++) 
            if (!visited[i])
                if (dfs(i, adj, visited, inRec)) 
                    return true;
        
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inRec) {
        visited[node] = true;
        inRec[node] = true;
        
        for (int i : adj.get(node)) {
            if (inRec[i]) 
                return true;
            if (!visited[i] && dfs(i, adj, visited, inRec)) 
                return true;
        }
        
        inRec[node] = false;
        return false;
    }
}