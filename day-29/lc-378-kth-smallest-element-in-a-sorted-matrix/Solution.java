import java.util.*; 
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] curr = minHeap.poll();
            int row = curr[1];
            int col = curr[2];
            
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        
        return minHeap.poll()[0];
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[][] matrix = {
            {1,5,9}, {10,11,13}, {12,13,15}
        }; 

        int result = sol.kthSmallest(matrix, 8);
        System.out.println(result);
    }
}