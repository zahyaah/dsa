import java.util.*; 

public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length; 
        int[] sortedNums = nums.clone(); 
        Arrays.sort(sortedNums);
        HashMap<Integer, Integer> original = new HashMap<>(); 

        for (int i = 0; i < n; i++)
            original.put(nums[i], i);
        
        int swaps = 0; 
        for (int i = 0; i < n; i++) {
            if (sortedNums[i] != nums[i]) {
                swaps++; 

                // get the correct index for nums[i]
                int correctIndex = original.get(sortedNums[i]);
                
                // swap elements to their correct position
                original.put(nums[i], correctIndex);
                original.put(sortedNums[i], i);

                int t = nums[i]; 
                nums[i] = nums[correctIndex];
                nums[correctIndex] = t; 
            }
        }

        return swaps; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        System.out.println(sol.minSwaps(new int[] {2,8,5,4}));
        System.out.println(sol.minSwaps(new int[] {10,19,6,3,5}));
    }
}