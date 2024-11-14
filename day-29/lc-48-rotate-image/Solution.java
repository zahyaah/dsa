import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        // transponse, then reverse each row, ez

        int n = matrix.length; 

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = temp; 
            }
        }

        for (int i = 0; i < n; i++) {
            int start = 0, end = n-1; 

            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp; 
                start++; 
                end--; 
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        }; 
        sol.rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}