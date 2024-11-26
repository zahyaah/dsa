public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        
        for (int i = 1; i < n; i++) {
            int next = Math.min(next2, Math.min(next3, next5));
            dp[i] = next;
            
            if (next == next2) 
                next2 = 2 * dp[++i2];
            if (next == next3) 
                next3 = 3 * dp[++i3];
            if (next == next5) 
                next5 = 5 * dp[++i5];
        }
        
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int n = 10; 
        System.out.println(sol.nthUglyNumber(n));

        int m = 1; 
        System.out.println(sol.nthUglyNumber(m));
    }
}