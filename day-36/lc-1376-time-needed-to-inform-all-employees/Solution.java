import java.util.*; 

public class Solution {
    public int numOfMinutes(int n, int head, int[] manager, int[] time) {
        List<List<Integer>> sub = new ArrayList<>();
        
        for (int i = 0; i < n; i++) 
            sub.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                sub.get(manager[i]).add(i);
        }
        
        return dfs(head, sub, time);
    }
    
    public int dfs(int current, List<List<Integer>> sub, int[] inform) {
        int max = 0;
        for (int s : sub.get(current)) 
            max = Math.max(max, dfs(s, sub, inform));
        
        return max + inform[current];
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int n = 1; 
        int head = 0; 
        int[] managers = new int[] {-1}; 
        int[] informTime = new int[] {0}; 
        System.out.println(sol.numOfMinutes(n, head, managers, informTime));
    }
}