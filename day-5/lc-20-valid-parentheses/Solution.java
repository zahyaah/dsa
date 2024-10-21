// link - https://leetcode.com/problems/valid-parentheses/

import java.util.*; 
public class Solution {
    public boolean isValid(String s) {
        int n = s.length(); 
        if (n%2 != 0) //odd? its impossible to have valid pairs
            return false; 
        
        Stack<Character> stack = new Stack<>(); 
        char[] arr = s.toCharArray(); 
        
        for (char c: arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && soundsGood(c, stack.peek()))
                    stack.pop(); 
                else 
                    return false; 
            }
        }
        return stack.isEmpty();
    }
    public boolean soundsGood(char a, char b) {
        if (a == ')')
            return b == '(';
        if (a == ']')
            return b == '[';
        if (a == '}')
            return b == '{';
        return false; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";

        System.out.println(sol.isValid(s1) + " " + sol.isValid(s2) + " " + sol.isValid(s3) + " " + sol.isValid(s4));
    }
}