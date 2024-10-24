// link - https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
import java.util.*; 
public class Solution{
    public char[][] fill(int n, int m, char a[][]) {
        int top = 0; 
        int bottom = n-1; 
        int right = m-1; 
        int left = 0; 
        
        // TOP -> LEFT TO RIGHT 
        for (int i = left; i <= right; i++) {
            if (a[top][i] == 'O') {
                boom(a, top, i, n, m);
            }
        }
        
        // RIGHT -> TOP TO BOTTOM
        for (int i = top; i <= bottom; i++) {
            if (a[i][right] == 'O') {
                boom(a, i, right, n, m);
            }
        }
        
        // BOTTOM -> LEFT TO RIGHT
        for (int i = left; i <= right; i++) {
            if (a[bottom][i] == 'O') {
                boom(a, bottom, i, n, m);
            }
        }
        
        // LEFT -> TOP TO BOTTOM
        for (int i = top; i <= bottom; i++) {
            if (a[i][left] == 'O') {
                boom(a, i, left, n, m);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') 
                    a[i][j] = 'X';
                if (a[i][j] == '-')
                    a[i][j] = 'O'; 
            }
        }
        return a; 
    }
    static void boom(char[][] board, int row, int col, int n, int m) {
        int[][] directions = {
            {0, 1}, // right
            {1, 0}, // bottom
            {-1, 0}, // left
            {0, -1} // top
        }; 
        
        board[row][col] = '-'; // visited
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i][0]; 
            int newCol = col + directions[i][1]; 
            
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O') {
                boom(board, newRow, newCol, n, m);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        char[][] ts1 = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}
        };
        char[][] result1 = sol.fill(5, 4, ts1);

        char[][] ts2 = {
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}
        }; 
        char[][] result2 = sol.fill(5, 4, ts2);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
    }
}