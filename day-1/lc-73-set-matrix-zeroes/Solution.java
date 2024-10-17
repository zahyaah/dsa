import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length; 

        boolean[][] maintain = new boolean[n][m]; 
        // can also maintain row and col arrays separately
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 0)
                    maintain[i][j] = true; // mark
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maintain[i][j]) { 
                    for (int k = 0; k < m; k++) // entire ith row
                        mat[i][k] = 0; 
                    for (int k = 0; k < n; k++) // entire jth row
                        mat[k][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] ts1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int[][] ts2 = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };

        sol.setZeroes((ts1));
        System.out.println(Arrays.deepToString(ts1)); 
        // deepToString for 2D arrays

        sol.setZeroes(ts2);
        System.out.println(Arrays.deepToString(ts2));
    }
}


