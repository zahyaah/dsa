public class Solution {
    public int maxProduct(int[] nums) {
        // greedy approach
        int n = nums.length; 
        int first = 1, second = 1; 
        int max = Integer.MIN_VALUE; 

        for (int i = 0; i < n; i++) {
            if (first == 0)
                first = 1;
            if (second == 0)
                second = 1; 

            first = first*nums[i]; 
            second = second*nums[n-1-i];
            max = Math.max(max, Math.max(first, second)); 
        }
        
        return max == Integer.MIN_VALUE ? 0: max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] nums1 = new int[] {2,3,-2,4}; 
        System.out.println(sol.maxProduct(nums1));

        int[] nums2 = new int[] {-2,0,-1}; 
        System.out.println(sol.maxProduct(nums2));
    }
}