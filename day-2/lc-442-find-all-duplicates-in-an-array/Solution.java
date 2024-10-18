// link - https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
import java.util.*; 

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        int n = nums.length; 

        if (n < 2)
            return list; 

        int[] track = new int[100001];

        for (int num: nums)
            track[num]++; 
        
        for (int i = 0; i < track.length; i++) {
            if (track[i] == 2) {
                list.add(i);
            }
        }
        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {4,3,2,7,8,2,3,1};
        int[] ts2 = new int[] {1,1,2};
        int[] ts3 = new int[] {1};

        List<Integer> res1 = sol.findDuplicates(ts1);
        List<Integer> res2 = sol.findDuplicates(ts2);
        List<Integer> res3 = sol.findDuplicates(ts3);

        System.out.println(res1.toString() + " " + res2.toString() + " " + res3.toString());
    }
}