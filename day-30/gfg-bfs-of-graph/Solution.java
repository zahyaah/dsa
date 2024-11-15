import java.util.*; 

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>(); 
        boolean[] visited = new boolean[V]; // 0-indexed
        Queue<Integer> queue = new LinkedList<>(); 
        visited[0] = true; 
        queue.offer(0);

        while (!queue.isEmpty()) {
            int element = queue.poll(); 
            result.add(element);
            visited[element] = true; 

            for (int i: adj.get(element)) {
                if (!visited[i]) {
                    visited[i] = true; 
                    queue.offer(i);
                }
            }
        }

        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

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

        ArrayList<Integer> bfs = sol.bfsOfGraph(5, list);
        System.out.println(bfs.toString());
    }
}