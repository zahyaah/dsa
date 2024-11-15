import java.util.*; 

public class Solution {
    public static void dfs(int node, boolean[] visited, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        result.add(node);
        visited[node] = true; 

        for (int i: adj.get(node)) {
            if (!visited[i]) {
                dfs(i, visited, result, adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>(); 
        int V = adj.size(); 
        boolean[] visited = new boolean[V];
        dfs(0, visited, result, adj);
        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        // TEST CASE 1
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(1);
        list.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(4);
        list.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(2);
        list.add(list5);

        ArrayList<Integer> answer = sol.dfsOfGraph(list);
        System.out.println(answer.toString());
        

        // TEST CASE -2 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> node1 = new ArrayList<>();
        node1.add(1);
        node1.add(2);
        graph.add(node1);

        ArrayList<Integer> node2 = new ArrayList<>();
        node2.add(0);
        node2.add(2);
        graph.add(node2);

        ArrayList<Integer> node3 = new ArrayList<>();
        node3.add(0);
        node3.add(1);
        node3.add(3);
        node3.add(4);
        graph.add(node3);

        ArrayList<Integer> node4 = new ArrayList<>();
        node4.add(2);
        graph.add(node4);

        ArrayList<Integer> node5 = new ArrayList<>();
        node5.add(2);
        graph.add(node5);

        ArrayList<Integer> result2 = sol.dfsOfGraph(graph);
        System.out.println(result2.toString());
    }
}