import java.util.*; 

public class Solution {
    public ArrayList<String> findPath(int[][] mat) { 
        ArrayList<String> list = new ArrayList<>(); 
        int n = mat.length; 
        boolean[][] visited = new boolean[n][n];
        
        if (mat[0][0] == 1) 
            helper(0, 0, "", visited, list, mat); 

        if (list.size() == 0)
            list.add("-1");
        
        return list; 
    }
    public static void helper(int row, int col, String res, boolean[][] visited, ArrayList<String> list, int[][] mat) {
        int n = mat.length; 

        if (row == n-1 && col == n-1) {
            list.add(res);
            return; 
        }

        visited[row][col] = true; 

        // DOWN
        if (row+1 < n && !visited[row+1][col] && mat[row+1][col] == 1)
            helper(row+1, col, res + "D", visited, list, mat);
        
        // UP
        if (row-1 >= 0 && !visited[row-1][col] && mat[row-1][col] == 1)
            helper(row-1, col, res + "U", visited, list, mat);
        
        // RIGHT
        if (col+1 < n && !visited[row][col+1] && mat[row][col+1] == 1)
            helper(row, col+1, res+"R", visited, list, mat);

        // LEFT
        if (col-1 >= 0 && !visited[row][col-1] && mat[row][col-1] == 1)
            helper(row, col-1, res+"L", visited, list, mat);
        
        visited[row][col] = false; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] mat1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1}, 
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        }; 
        System.out.println(sol.findPath(mat1).toString());

        int[][] mat2 = {
            {1,0},
            {1,0}
        }; 
        System.out.println(sol.findPath(mat2).toString());
    }
}