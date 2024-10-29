import java.util.*; 

public class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);

        // find the median
        int totalOps = 0, median = nums[n/2];

        for (int num: nums)
            totalOps += Math.abs(median-num);
        
        return totalOps; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        System.out.println(sol.minMoves2(new int[] {1,2,3}));
        System.out.println(sol.minMoves2(new int[] {1,10,2,9}));
    }
}