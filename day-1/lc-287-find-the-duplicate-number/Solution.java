// link - https://leetcode.com/problems/find-the-duplicate-number/description/

// assuming the array to be a linked list 
// and there exists a cycle (because of the duplicate)
// Floyd's Tortoise and Hare Algorithm
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast); // cycle found 

        // reset to the start 
        slow = nums[0]; 
        
        // move each pointer by one
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {3,3,3,3,3};

        int result1 = sol.findDuplicate(nums1);
        int result2 = sol.findDuplicate(nums2);
        int result3 = sol.findDuplicate(nums3);

        System.out.println(result1 + " " + result2 + " " + result3);

    }
}