public class Solution {
    public int minCost(String colors, int[] time) {
        int n = colors.length(); 
        int total = 0; 

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                total += Math.min(time[i], time[i - 1]);
                time[i] = Math.max(time[i], time[i - 1]);
            }
        }
        
        return total;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s = "abaac";
        int[] time = {1,2,3,4,5};
        System.out.println(sol.minCost(s, time));

        String t = "abc";
        int[] lime = {1,2,3};
        System.out.println(sol.minCost(t, lime));
    }
}