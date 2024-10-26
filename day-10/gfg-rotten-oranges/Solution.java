import java.util.*; 
public class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length; 
        
        int fresh = 0; 
        Queue<int[]> queue = new LinkedList<>(); 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    fresh++; 
                if (mat[i][j] == 2)
                    queue.offer(new int[] {i, j}); 
            }
        }
        if (fresh == 0)
            return 0; 
        int min = 0; 
        int[][] directions = {
            {0,1}, 
            {1, 0},
            {-1, 0}, 
            {0, -1}
        }; 
        
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            boolean isRotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] coor = queue.poll(); 
                int row = coor[0], col = coor[1]; 
                
                for (int j = 0; j < 4; j++) {
                    int newRow = row+directions[j][0]; 
                    int newCol = col+directions[j][1]; 
                    
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1) {
                        mat[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--; 
                        isRotten = true;
                    }
                }
            }
            
            if (isRotten)
                min++; 
        }
        
        return fresh == 0 ? min : -1; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] mat1 = {
            {0, 1, 2}, 
            {0, 1, 2}, 
            {2, 1, 1}
        };
        
        int[][] mat2 = {
            {2, 2, 0, 1}
        };
        
        int[][] mat3 = {
            {2, 2, 2}, 
            {0, 2, 0}
        };

        System.out.println(sol.orangesRotting(mat1));
        System.out.println(sol.orangesRotting(mat2));
        System.out.println(sol.orangesRotting(mat3));
    }
}