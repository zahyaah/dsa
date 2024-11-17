import java.util.*; 

public class Solution {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++)
            if (!visited[i]) 
                if (dfs(i, -1, adj, visited)) 
                    return true; 
                
        return false; 
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited)) {
                    return true;
                }
            } 
            else if (neighbor != parent)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        // int[][] arr = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        int[][] arr = {{}, {2}, {1, 3}, {2}};
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int[] subArray : arr) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : subArray) {
                list.add(num);
            }
            adjList.add(list);
        }

        System.out.println(sol.isCycle(adjList));
    }
}