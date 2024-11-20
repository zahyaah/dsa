import java.util.*; 

public class Solution {
    int maxLen(int arr[]) {
        int n = arr.length; 
        Map<Integer, Integer> map = new HashMap<>(); 
        int max = Integer.MIN_VALUE, sum = 0; 
        
        for (int i = 0; i < n; i++) {
            sum += arr[i]; 
            
            if (sum == 0)
                max = i+1; 
            
            if (map.containsKey(sum))
                max = Math.max(i-map.get(sum), max); 
            else 
                map.put(sum, i);
        }
        
        return max == Integer.MIN_VALUE ? 0 : max; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {15, -2, 2, -8, 1, 7, 10, 23};
        int[] ts2 = new int[] {2, 10, 4}; 
        int[] ts3 = new int[] {1, 0, -4, 3, 1, 0}; 

        System.out.println(sol.maxLen(ts1));
        System.out.println(sol.maxLen(ts2));
        System.out.println(sol.maxLen(ts3));
    }
}