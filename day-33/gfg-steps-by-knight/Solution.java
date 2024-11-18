import java.util.*; 

class Pair {
    int a, b; 
    public Pair(int a, int b) {
        this.a = a;
        this.b = b; 
    }
}

public class Solution {
    public int minStepToReachTarget(int knight[], int target[], int N) {
        boolean[][] visited = new boolean[N+1][N+1]; // 'cause 1-based indexing 
        visited[knight[0]][knight[1]] = true; 
        int steps = 0; 

        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(knight[0], knight[1]));

        // directions
        int[][] directions = new int[][] {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, -2},
            {1, 2},
            {-1, 2},
            {-1, -2}
        }; 

        while (!queue.isEmpty()) {
            int size = queue.size(); 

            for (int i = 0; i < size; i++) {
                Pair temp = queue.poll(); 
                int x = temp.a; 
                int y = temp.b; 

                if (x == target[0] && y == target[1])
                    return steps;

                for (int k = 0; k < 8; k++) {
                    int newX = x+directions[k][0]; 
                    int newY = y+directions[k][1]; 

                    if (newX > 0 && newX <= N && newY > 0 && newY <= N && !visited[newX][newY]) {
                        visited[newX][newY] = true; 
                        queue.offer(new Pair(newX, newY));
                    }
                }
            }
            steps++; 
        }
        return -1; // Return -1 if target is not reachable    
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int n = 6; 
        int[] kpos = new int[] {4, 5}; 
        int[] tpos = new int[] {1, 1}; 

        System.out.println(sol.minStepToReachTarget(kpos, tpos, n));   
    }
}