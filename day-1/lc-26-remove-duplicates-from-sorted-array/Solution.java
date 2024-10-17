// link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int maintain = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[maintain++] = nums[i]; 
            }
        }
        return maintain; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {1,1,2};
        int[] ts2 = new int[] {0,0,1,1,1,2,2,3,3,4};

        int res1 = sol.removeDuplicates(ts1);
        int res2 = sol.removeDuplicates(ts2);

        System.out.println(res1 + " " + res2);
    }
}