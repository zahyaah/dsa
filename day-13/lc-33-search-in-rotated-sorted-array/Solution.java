public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; 
        int low = 0, high = n-1; 

        while (low <= high) {
            int mid = low + (high-low)/2; 

            if (nums[mid] == target)
                return mid; 
            
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid-1; 
                else 
                    low = mid+1; 
            } else {
                if (nums[mid] <= target && target <= nums[high]) 
                    low = mid+1; 
                else 
                    high = mid-1; 
            }
        }

        return -1; 
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        int[] ts1 = new int[] {4,5,6,7,0,1,2};
        int target1 = 0; 
        System.out.println(sol.search(ts1, target1));

        int[] ts2 = new int[] {4,5,6,7,0,1,2};
        int target2 = 3;
        System.out.println(sol.search(ts2, target2));
    }
}