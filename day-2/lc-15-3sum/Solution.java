// link - https://leetcode.com/problems/3sum/description/

import java.util.*; 
public class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); 
        Set<List<Integer>> set = new HashSet<>(); 
        int n = nums.length; 

        Arrays.sort(nums);

        for (int start = 0; start < n-2; start++) {
            int mid = start+1; 
            int end = n-1; 

            while (mid < end) {
                int sum = nums[start]+nums[mid]+nums[end];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[start], nums[mid], nums[end]));
                    mid++; 
                    end--; 
                }
                else if (sum < 0)
                    mid++; 
                else 
                    end--; 
            }
        }

        list.addAll(set);
        return list; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] T1 = new int[] {-1,0,1,2,-1,-4};
        int[] T2 = new int[] {0,1,1};
        int[] T3 = new int[] {0,0,0};

        List<List<Integer>> res1 = sol.threeSum(T1);
        List<List<Integer>> res2 = sol.threeSum(T2);
        List<List<Integer>> res3 = sol.threeSum(T3);

        System.out.println(res1.toString());
        System.out.println(res2.toString());
        System.out.println(res3.toString());
    }
}