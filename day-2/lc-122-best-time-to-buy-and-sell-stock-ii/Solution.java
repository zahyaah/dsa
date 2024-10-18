public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0, n = prices.length; 

        for (int i = 1; i < n; i++) {
            if (prices[i-1] < prices[i]) {
                sum += (prices[i]-prices[i-1]);
            }
        }
        return sum; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {7,1,5,3,6,4};
        int[] ts2 = new int[] {1,2,3,4,5};
        int[] ts3 = new int[] {7,6,4,3,1};


        int res1 = sol.maxProfit(ts1);
        int res2 = sol.maxProfit(ts2);
        int res3 = sol.maxProfit(ts3); 
        System.out.println(res1 + " " + res2 + " " + res3);
    }
}