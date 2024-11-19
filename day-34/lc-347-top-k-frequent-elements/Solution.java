import java.util.*; 

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1); 
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue()-b.getValue()
        ); 

        for (Map.Entry<Integer, Integer> each: map.entrySet()) {
            pq.offer(each);

            if (pq.size() > k)
                pq.poll(); 
        }

        int[] result = new int[k]; 
        int index = 0; 
        while (!pq.isEmpty())
            result[index++] = pq.poll().getKey(); 
        
        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] num1 = new int[] {1,1,1,2,2,3}; 
        int k1 = 2; 
        int[] res1 = sol.topKFrequent(num1, k1); 
        System.out.println(Arrays.toString(res1));

        int[] num2 = new int[] {1}; 
        int k2 = 1; 
        int[] res2 = sol.topKFrequent(num2, k2); 
        System.out.println(Arrays.toString(res2));
    }
}