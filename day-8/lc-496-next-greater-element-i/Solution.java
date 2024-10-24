// link - https://leetcode.com/problems/next-greater-element-i/
import java.util.*; 
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length; 

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int i = m-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[stack.peek()] <= nums2[i])
                stack.pop(); 

            if (stack.isEmpty())
                map.put(nums2[i], -1);
            else 
                map.put(nums2[i], nums2[stack.peek()]);

            stack.push(i);
        }

        for (int i = 0; i < n; i++)
            res[i] = map.get(nums1[i]); 

        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] res1 = sol.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
        int[] res2 = sol.nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4}); 

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
}