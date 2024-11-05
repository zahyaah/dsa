import java.util.Arrays;

public class Solution {
    public int[] countBits(int n) {
        // int[] result = new int[n+1];

        // for (int i = 0; i <= n; i++) {
        //     result[i] = Integer.bitCount(i);
        // }
        // return result; 

        // but dp?

        int[] dp = new int[n+1];
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            if ((i&1) == 1) 
                dp[i] = dp[i-1]+1; 
            else 
                dp[i] = dp[i>>1];
            // or dp[i] = dp[i>>1] + (i&1);
        }

    // from progammersoumen
    // If ( i ) is even, the number of 1s in ( i ) is the same as the number of 1s in 
    // ( i/2 ) (right-shifting an even number halves it without adding a new 1).

    // If ( i ) is odd, the number of 1s in ( i ) is the number of 1s in ( i - 1 ) 
    // plus one additional 1 (as adding 1 to an even number makes it odd).
  

        return dp; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] res = sol.countBits(2); 
        int[] res2 = sol.countBits(5);

        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
}