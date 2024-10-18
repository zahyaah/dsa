// link - https://leetcode.com/problems/two-sum/
import java.util.*; 
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int n = nums.length; 

        for (int i = 0; i < n; i++) {
            int present = target-nums[i];

            if (map.containsKey(present)) 
                return new int[] {map.get(present), i};

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        int[] ts1 = new int[] {2,7,11,15};
        int T1 = 9; 

        int[] ts2 = new int[] {3,2,4};
        int T2 = 6;

        int[] ts3 = new int[] {3, 3};
        int T3 = 6; 

        int[] res1 = sol.twoSum(ts1, T1);
        int[] res2 = sol.twoSum(ts2, T2);
        int[] res3 = sol.twoSum(ts3, T3);

        System.out.println(Arrays.toString(res1) + " " + Arrays.toString(res2) + " " + Arrays.toString(res3));
    }
}