// link - https://leetcode.com/problems/sort-colors/

// based on dutch national flag alg. 

//  LOW -> MID-1    ---- 0
// MID-1 -> HIGH-1  ---- 1
// HIGH-1 -> END-1  ---- 2

import java.util.Arrays;
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length; 
        int start = 0, mid = 0, end = n-1; 

        while (mid <= end) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp; 
                start++; 
                mid++;
            } else if (nums[mid] == 1) {
                mid++; 
            } else {
                int tempAgain = nums[mid];
                nums[mid] = nums[end];
                nums[end] = tempAgain; 
                end--; 
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] ts1 = {2,0,2,1,1,0};
        int[] ts2 = {2, 0, 1};

        sol.sortColors(ts1);
        System.out.println(Arrays.toString(ts1));
        
        sol.sortColors(ts2);
        System.out.println(Arrays.toString(ts2));
        
    }
}