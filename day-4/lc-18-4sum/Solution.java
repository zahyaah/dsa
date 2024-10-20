// link - https://leetcode.com/problems/4sum/

import java.util.*; 
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>(); // for unique quadruplets
        int n = nums.length; 
        Arrays.sort(nums);


        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int third = j+1; 
                int fourth = n-1; 

                while (third < fourth) {
                    long sum = (long)nums[i]+nums[j]+nums[third]+nums[fourth];

                    if (sum == target) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[third],nums[fourth]));
                        third++; 
                        fourth--; 
                    } else if (sum < target) {
                        third++; 
                    } else {
                        fourth--;
                    }
                }
                                
            }
        }

        list.addAll(set);
        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] T1 = new int[] {1,0,-1,0,-2,2};
        int target1 = 0; 

        int[] T2 = new int[] {2,2,2,2,2}; 
        int target2 = 8; 

        List<List<Integer>> res1 = sol.fourSum(T1, target1);
        List<List<Integer>> res2 = sol.fourSum(T2, target2);

        System.out.println(res1.toString());
        System.out.println(res2.toString());
    }
}