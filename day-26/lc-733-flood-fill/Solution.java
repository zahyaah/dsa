import java.util.Arrays;

class Solution {
    public int[][] floodFill(int[][] image, int row, int col, int color) {
        int n = image.length; 
        int m = image[0].length;
        int og_color = image[row][col]; 

        if (og_color != color) {
            filled(image, row, col, n, m, color, og_color);
        }
        return image;
    }
    public void filled(int[][] image, int row, int col, int n, int m, int color, int og_color) {
        int[][] directions = {
            {0, 1}, 
            {1, 0},
            {-1, 0},
            {0, -1}
        };

        image[row][col] = color; 
        for (int i = 0; i < 4; i++) {
            int newRow = directions[i][0] + row; 
            int newCol = directions[i][1] + col;

            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && image[newRow][newCol] == og_color)
                filled(image, newRow, newCol, n, m, color, og_color);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] image1 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        
        int[][] image2 = {
            {0, 0, 0},
            {0, 0, 0}
        };

        int[][] result1 = sol.floodFill(image1, 1, 1, 2);
        int[][] result2 = sol.floodFill(image2, 0, 0, 0);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
    }
}