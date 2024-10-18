public class Solution {
    public int maxArea(int[] height) {
        int n = height.length; 

        int start = 0, end = n-1; 
        int MAX = Integer.MIN_VALUE; 

        while (start < end) {
            int temp = Math.min(height[start], height[end]);

            int calc = temp*(end-start);
            MAX = Math.max(calc, MAX);

            if (height[start] < height[end])
                start++; 
            else
                end--;
        }

        return MAX; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        int[] T1 = new int[] {1,8,6,2,5,4,8,3,7};
        int[] T2 = new int[] {1,1};

        int res1 = sol.maxArea(T1);
        int res2 = sol.maxArea(T2);
        System.out.println(res1 + " " + res2);
    }
}