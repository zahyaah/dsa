// link - https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
import java.util.*; 
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length; 
        int sum = 0, count = 0;     

        for (int i = 0; i < n; i++) {
            sum += nums[i]; 

            int remainder = sum%k; 
            if (remainder < 0)
                remainder += k; 
                // Every time you encounter a remainder (from prefixSum % k) that has already been seen, 
                // you know there is a subarray whose sum is divisible by k.
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
                map.put(remainder, map.get(remainder)+1);
            }
            else 
                map.put(remainder, 1);
        }
        return count; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] ts1 = new int[]{4,5,0,-2,-3,1};
        int k1 = 5; 

        int[] ts2 = new int[]{5};
        int k2 = 9; 

        int res1 = sol.subarraysDivByK(ts1, k1);
        int res2 = sol.subarraysDivByK(ts2, k2);

        System.out.println(res1 + "  " + res2);
    }
}

// Every time you encounter a remainder that has been seen before 
// (e.g., remainder 4 in the above example), it means that there 
// are multiple subarrays that have a sum divisible by k. The value 
// map.get(remainder) tells you how many times this remainder has been 
// encountered so far. For each of those occurrences, there is a corresponding 
// subarray whose sum is divisible by k.