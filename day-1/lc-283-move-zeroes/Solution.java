// link - https://leetcode.com/problems/move-zeroes/
import java.util.*; 
public class Solution {
    public void moveZeroes(int[] nums) {
        int maintain = 0, n = nums.length; 

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[maintain++] = nums[i];
            }
        }

        while (maintain < n) {
            nums[maintain++] = 0; 
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] ts1 = new int[] {0,1,0,3,12};
        int[] ts2 = new int[] {0};

        sol.moveZeroes(ts1);
        System.out.println(Arrays.toString(ts1));

        sol.moveZeroes(ts2);
        System.out.println(Arrays.toString(ts2));
    }
}