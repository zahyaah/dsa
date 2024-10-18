// link - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class Solution {
    public int maxScore(int[] cards, int k) {
        int total = 0; 
        for (int card: cards)
            total += card; 

        int n = cards.length; 
        int current = 0; 
        int win = n-k; 

        for (int i = 0; i < win; i++)
            current += cards[i]; 
        
        int min = current; 

        for (int i = win; i < n; i++) {
            current += cards[i] - cards[i-win];
            min = Math.min(current, min);
        }

        return total - min; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {1,2,3,4,5,6,1}; 
        int k1 = 3; 
        int res1 = sol.maxScore(ts1, k1);

        int[] ts2 = new int[] {2,2,2}; 
        int k2 = 2; 
        int res2 = sol.maxScore(ts2, k2);

        int[] ts3 = new int[] {9,7,7,9,7,7,9}; 
        int k3 = 7;
        int res3 = sol.maxScore(ts3, k3);

        System.out.println(res1 + " " + res2 + " " + res3);
    }
}