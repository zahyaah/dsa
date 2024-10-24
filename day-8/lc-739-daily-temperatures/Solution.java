// link - https://leetcode.com/problems/daily-temperatures/

import java.util.*; 
public class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // next greater element index greater to the right in disguise
        int n = temp.length; 
        Stack<Integer> stack = new Stack<>(); 
        
        int[] result = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i])
                stack.pop(); 
            
            if (stack.isEmpty())
                result[i] = 0; 
            else
                result[i] = stack.peek()-i; 
            
            stack.push(i);
        }

        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] ts1 = new int[] {73,74,75,71,69,72,76,73}; 
        int[] ts2 = new int[] {30,40,50,60}; 
        int[] ts3 = new int[] {30,60,90};

        int[] res1 = sol.dailyTemperatures(ts1);
        int[] res2 = sol.dailyTemperatures(ts2);
        int[] res3 = sol.dailyTemperatures(ts3);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}