// link - https://leetcode.com/problems/game-of-life/

import java.util.Arrays;

public class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length; 
        int m = board[0].length; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int totalLives = countLives(board, i, j, n, m);

                if (board[i][j] == 1) {
                    if (totalLives < 2 || totalLives > 3)
                        board[i][j] = 2; // kill
                } 
                else {
                    if (totalLives == 3) 
                        board[i][j] = -1; // revive
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0; 
                else if (board[i][j] == -1) 
                    board[i][j] = 1; 
            }
        }
    }
    public static int countLives(int[][] board, int i, int j, int n, int m) {
        int lives = 0; 
        int[][] directions = {
            {0, 1},
            {1, 0}, 
            {-1, 0}, 
            {0, -1}, 
            {-1, -1}, 
            {1, 1}, 
            {-1, 1},
            {1, -1}
        }; 

        for (int index = 0; index < 8; index++) {
            int newRow = i+directions[index][0]; 
            int newCol = j+directions[index][1]; 

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                    lives++; 
                }
            }
        }

        return lives; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] ts1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        sol.gameOfLife(ts1);

        int[][] ts2 = {
            {1, 1},
            {1, 0}
        }; 
        sol.gameOfLife(ts2);

        System.out.println(Arrays.deepToString(ts1));
        System.out.println(Arrays.deepToString(ts2));
    }
}

// live < (2 live neighbours) DIES
// live <= 2 or 3 live LIVE 
// live >= 3 DIES 
// dead === 3 lives LIVES 