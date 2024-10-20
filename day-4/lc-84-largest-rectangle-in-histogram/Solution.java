// link - https://leetcode.com/problems/largest-rectangle-in-histogram/description/
import java.util.*; 
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] R = nextSmallestElementIndexToTheRight(heights);
        int[] L = nextSmallestElementIndexToTheLeft(heights);
        int n = heights.length; 
        int MAX = Integer.MIN_VALUE; 
        int calculate = 1;

        for (int i = 0; i < n; i++) {
            if (L[i] == -1) {
                calculate = heights[i]*R[i]; 
            } else {
                calculate = heights[i] * (R[i] - L[i] - 1);
            }
            MAX = Math.max(calculate, MAX);
        }
        return MAX; 
    }
    public int[] nextSmallestElementIndexToTheRight(int[] arr) {
        int n = arr.length; 
        Stack<Integer> stack = new Stack<>(); 
        int[] result = new int[n];
        
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop(); 
            
            if (stack.isEmpty())
                result[i] = n; 
            else 
                result[i] = stack.peek(); 
            
            stack.push(i);
        }
        
        return result; 
    }

    public int[] nextSmallestElementIndexToTheLeft(int[] arr) {
        int n = arr.length; 
        Stack<Integer> stack = new Stack<>(); 
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop(); 
            }
            if (stack.isEmpty())
                result[i] = -1; 
            else 
                result[i] = stack.peek(); 
            stack.push(i);
        }
        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] ts1 = new int[] {2,1,5,6,2,3}; 
        int[] ts2 = new int[] {2,4}; 

        int res1 = sol.largestRectangleArea(ts1);
        int res2 = sol.largestRectangleArea(ts2);

        System.out.println(res1 + " " + res2); 
    }
}