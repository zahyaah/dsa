// link - https://leetcode.com/problems/majority-element/

import java.util.*;
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {3, 2, 3};
        int[] ts2 = new int[] {2,2,1,1,1,2,2};

        int res1 = sol.majorityElement(ts1);
        int res2 = sol.majorityElement(ts2);
        System.out.println(res1 + " " + res2);
    }
}