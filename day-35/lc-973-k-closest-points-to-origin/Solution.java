import java.util.*; 
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1])
        ); 

        for (int[] each: points) {
            pq.offer(each);

            if (pq.size() > k)
                pq.poll(); 
        }
        int[][] res = new int[k][]; 
        int n = k-1; 
        while (!pq.isEmpty()) {
            res[n--] = pq.poll(); 
        }
        
        return res; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        int[][] ts1 = new int[][] {
            {1,3},
            {-2,2}
        }; 
        int k1 = 1; 
        System.out.println(Arrays.deepToString(sol.kClosest(ts1, k1)));
    }
}