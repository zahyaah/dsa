import java.util.*; 

public class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxDist = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        grid[newX][newY] = grid[x][y] + 1;
                        maxDist = Math.max(maxDist, grid[newX][newY] - 1);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return maxDist;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[][] grid1 = {{1,0,1},{0,0,0},{1,0,1}};
        int[][] grid2 = {{1,0,0},{0,0,0},{0,0,0}};

        System.out.println(sol.maxDistance(grid1));
        System.out.println(sol.maxDistance(grid2));
    }
}