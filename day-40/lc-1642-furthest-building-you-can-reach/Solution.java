import java.util.*; 

public class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < h.length - 1; i++) {
            int diff = h[i + 1] - h[i];
            if (diff > 0) {
                pq.add(diff);
                if (pq.size() > l)
                    b -= pq.poll();
                
                if (b < 0) 
                    return i;
            }
        }
        return h.length - 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] heights = new int[] {4,2,7,6,9,14,12};
        int bricks = 5; 
        int ladders = 1; 
        System.out.println(sol.furthestBuilding(heights, bricks, ladders));
    }
}