// link - https://leetcode.com/problems/spiral-matrix/

import java.util.*; 
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>(); 
        int n = matrix.length; 
        int m = matrix[0].length; 

        int top = 0, bottom = n-1; 
        int left = 0, right = m-1; 

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++; 
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--; 
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--; 
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++; 
            }
        }
        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[][] ts1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] ts2 = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        List<Integer> res1 = sol.spiralOrder(ts1);
        List<Integer> res2 = sol.spiralOrder(ts2);

        System.out.println(res1.toString());
        System.out.println(res2.toString());
    }
}