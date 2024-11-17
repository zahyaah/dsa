import java.util.*; 

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];  // -1: unvisited, 0: unsafe, 1: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] != 0) 
            return state[node] == 1; 
    
        state[node] = -1;

        for (int neighbor : graph[node]) {
            if (state[neighbor] == -1 || !dfs(neighbor, graph, state))
                return false;  
        }

        state[node] = 1;
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[][] graph1 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graph2 = {{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> list1 = sol.eventualSafeNodes(graph1);
        List<Integer> list2 = sol.eventualSafeNodes(graph2);

        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }
}