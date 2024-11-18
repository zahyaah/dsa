import java.util.*; 

public class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] colors = new int[V]; 
        Arrays.fill(colors, -1); 

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                colors[i] = 0; 
                if (help(i, colors, adj)) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
    public boolean help(int node, int[] colors, ArrayList<ArrayList<Integer>> adj) {
        for (int each: adj.get(node)) {
            if (colors[each] == -1) {
                colors[each] = 1-colors[node]; 
                if (help(each, colors, adj))
                    return true; 
            } 
            else if (colors[each] == colors[node])
                return true; 
        }
        return false; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        // Create the adjacency list
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(3).add(1);
        adj.get(3).add(2);

        // Check if the graph is bipartite
        boolean result = sol.isBipartite(V, adj);
        System.out.println("Is the graph bipartite? " + result);
    }
}