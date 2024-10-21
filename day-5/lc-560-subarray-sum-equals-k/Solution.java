// link - https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.*; 
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        map.put(0, 1);
        int count = 0; 

        for (int num: nums) {
            preSum += num; 

            if (map.containsKey(preSum-k)) {
                count += map.get(preSum-k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {1, 1,1}; 
        int k1 = 2; 

        int[] ts2 = new int[] {1,2,3}; 
        int k2 = 3; 

        int res1 = sol.subarraySum(ts1, k1);
        int res2 = sol.subarraySum(ts2, k2);

        System.out.println(res1 + " " + res2);
    }
}