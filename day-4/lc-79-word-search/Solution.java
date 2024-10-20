public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] store = word.toCharArray(); 
        int n = board.length; 
        int m = board[0].length; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == store[0]) {
                    if (word.length() == 1 || traverseAllDirections(board, store, i, j, 0, n, m)) {
                        return true; 
                    }
                }
            }
        }
        return false; 
    }
    public boolean traverseAllDirections(char[][] board, char[] store, int i, int j, int index, int n, int m) {
        if (index == store.length)
            return true; 
        
        if (board[i][j] != store[index])
            return false; 
        
        int[][] directions = {
            {0, 1}, // right 
            {1, 0}, // down
            {-1, 0}, // up
            {0, -1} // left
        };

        char temp = board[i][j]; 
        board[i][j] = '%'; 

        for (int k = 0; k < 4; k++) {
            int newRow = i+directions[k][0]; 
            int newCol = j+directions[k][1]; 

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                if (traverseAllDirections(board, store, newRow, newCol, index + 1, n, m)) {
                    return true;
                }
            }
        }

        board[i][j] = temp;
        return false; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        char[][] T1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";

        char[][] T2 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word2 = "SEE";

        char[][] T3 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCB";


        System.out.println(sol.exist(T1, word1) + " " + sol.exist(T2, word2) + " " + sol.exist(T3, word3));
    }
}