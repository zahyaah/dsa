import java.util.*; 

public class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        List<int[]> island = new ArrayList<>();
        boolean found = false;
        
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, island);
                    found = true;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int[] cell : island) {
            queue.offer(cell);
        }
        
        int flips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                
                for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                        if (grid[nr][nc] == 1) {
                            return flips;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            flips++;
        }
        
        return flips;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int r, int c, List<int[]> island) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        island.add(new int[]{r, c});
        
        for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
            dfs(grid, visited, r + dir[0], c + dir[1], island);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        

        int[][] grid1 = {{0,1},{1,0}};
        int[][] grid2 = {{0,1,0},{0,0,0},{0,0,1}};
        int[][] grid3 = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};

        System.out.println(sol.shortestBridge(grid1));
        System.out.println(sol.shortestBridge(grid2));
        System.out.println(sol.shortestBridge(grid3));
    }
}