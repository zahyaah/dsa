import java.util.*; 

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(); 
        List<Integer> sorted = new ArrayList<>(); 
        int n = nums.length; 

        for (int i = n-1; i >= 0; i--) {
            int check = nums[i];
            
            // finding the position of check in sorted
            int insertPos = find(sorted, check);
            res.add(insertPos);
            sorted.add(insertPos, check);
        }

        Collections.reverse(res);
        return res; 
    }
    public int find(List<Integer> list, int target) {
        int low = 0, high = list.size(); 

        while (low < high) {
            int mid = low + (high-low)/2; 

            if (list.get(mid) < target)
                low = mid+1; 
            else 
                high = mid; 
        }
        return low; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {5,2,6,1}; 
        int[] ts2 = new int[] {-1}; 
        int[] ts3 = new int[] {-1,-1};

        List<Integer> res1 = sol.countSmaller(ts1);
        List<Integer> res2 = sol.countSmaller(ts2);
        List<Integer> res3 = sol.countSmaller(ts3);

        System.out.println(res1.toString());
        System.out.println(res2.toString());
        System.out.println(res3.toString());

    }
}