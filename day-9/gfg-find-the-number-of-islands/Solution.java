// link - https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        boolean[][] visited = new boolean[n][m]; 
        int count = 0; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++; 
                    traverse(grid, visited, i, j, n, m);
                }
            }
        }
        return count; 
    }   
    public void traverse(char[][] grid, boolean[][] visited, int row, int col, int n, int m) {
        int[][] directions = {
            {0, 1}, // right
            {1, 0}, // bottom
            {-1, 0}, // left
            {0, -1}, // top
            {-1, -1}, // top diagonally left
            {1, 1}, // bottom diagonally right 
            {1, -1}, // bottom diagonally left
            {-1, 1} // top diagonally right 
        };
        visited[row][col] = true; 
        grid[row][col] = '-';
        
        for (int i = 0; i < 8; i++) {
            int newRow = row + directions[i][0]; 
            int newCol = col + directions[i][1]; 
            
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == false && grid[newRow][newCol] == '1') {
                traverse(grid, visited, newRow, newCol, n, m);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        char[][] ts1 = {
            {'0','1'},
            {'1','0'},
            {'1','1'},
            {'1','0'}
        };
        System.out.println(sol.numIslands(ts1));

        char[][] ts2 = {
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };
        System.out.println(sol.numIslands(ts2));
    }
}