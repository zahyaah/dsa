public class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0; 
        int n = grid.length; 
        int m = grid[0].length; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islands++; 
                    traverse(i, j, n, m, grid);
                }
            }
        }

        return islands; 
    }
    public void traverse(int row, int col, int n, int m, char[][] grid) {
        int[][] directions = {
            {0, 1}, 
            {1, 0}, 
            {-1, 0},
            {0, -1}
        }; 

        // marked
        grid[row][col] = '0';

        for (int i = 0; i < 4; i++) {
            int newRow = row+directions[i][0]; 
            int newCol = col+directions[i][1]; 

            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == '1') 
                traverse(newRow, newCol, n, m, grid);
        }
 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int result1 = sol.numIslands(grid1);
        int result2 = sol.numIslands(grid2); 
        System.out.println(result1 + " " + result2);
    }
}