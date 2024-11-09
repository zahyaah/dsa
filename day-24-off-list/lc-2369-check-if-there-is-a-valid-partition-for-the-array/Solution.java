public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length; 
        // boolean[] dp = new boolean[] {true, false, n > 1 && nums[0] == nums[1]};
        boolean a = true; 
        boolean b = false; 
        boolean c = (n > 1 && nums[0] == nums[1]);
        // dp[0] -> it's empty array, so it's true initially 
        // dp[1] -> first element, so false 
        // dp[2] -> check if last and current element are equal or not, ez 

        for (int i = 2; i < n; i++) {
            boolean current = false; 

            if (nums[i] == nums[i-1] && b)
                current = true; 
            else if (nums[i] == nums[i-1] && nums[i-1] == nums[i-2] && a)
                current = true; 
            else if (nums[i] == nums[i-1]+1 && nums[i-1] == nums[i-2]+1 && a)
                current = true; 
            
            a = b; 
            b = c; 
            c = current; 
        }

        return c;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] arr = new int[] {4,4,4,5,6}; 
        int[] brr = new int[] {1,1,1,2};

        System.out.println(sol.validPartition(arr));
        System.out.println(sol.validPartition(brr));
    }
}