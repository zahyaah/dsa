// link - https://leetcode.com/problems/jump-game/description/

public class Solution {
    public boolean canJump(int[] nums) {
        int gas = 0; 

        for (int num: nums) {
            if (gas < 0)
                return false; 
            else if (num > gas) {
                gas = num; 
            }
            gas--; 
        }
        return true; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] T1 = new int[] {2,3,1,1,4};
        int[] T2 = new int[] {3,2,1,0,4};

        System.out.println(sol.canJump(T1) + " " + sol.canJump(T2));
    }
}


// best explanation
// https://leetcode.com/problems/jump-game/solutions/4534808/super-simple-intuitive-8-line-python-solution-beats-99-92-of-users/