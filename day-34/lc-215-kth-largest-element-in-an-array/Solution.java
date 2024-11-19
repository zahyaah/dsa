import java.util.*; 

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll(); // remove the smallest, if heap size exceeds k
        }

        return minHeap.poll();
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] num1 = new int[] {3,2,1,5,6,4}; 
        int k1 = 2; 
        System.out.println(sol.findKthLargest(num1, k1));

        int[] num2 = new int[] {3,2,3,1,2,4,5,5,6}; 
        int k2 = 4; 
        System.out.println(sol.findKthLargest(num2, k2));
    }
}