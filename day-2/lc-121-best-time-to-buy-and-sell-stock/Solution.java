public class Solution {
    public int maxProfit(int[] prices) {
        int MIN = Integer.MAX_VALUE; 
        int n = prices.length; 
        int max = 0; 

        for (int i = 0; i < n; i++) {
            MIN = Math.min(prices[i], MIN); 
            max = Math.max(prices[i]-MIN, max);
        }
        return max; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {7,1,5,3,6,4};
        int[] ts2 = new int[] {7,6,4,3,1};

        int res1 = sol.maxProfit(ts1);
        int res2 = sol.maxProfit(ts2);
        System.out.println(res1 + " " + res2);
    }
}