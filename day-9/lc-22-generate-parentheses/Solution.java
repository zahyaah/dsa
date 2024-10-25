// link - https://leetcode.com/problems/generate-parentheses/

import java.util.*; 
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>(); 
        backtrack(list, "", 0, 0, n);
        return list; 
    }
    public void backtrack(List<String> list, String s, int open, int close, int n) {
        // string balanced
        if (open == n && close == n) { 
            list.add(s);
            return; 
        }

        if (open < n) {
            backtrack(list, s + "(", open+1, close, n);
        } 
        
        if (close < open) {
            backtrack(list, s + ")", open, close+1, n);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        List<String> ts1 = sol.generateParenthesis(3); 
        List<String> ts2 = sol.generateParenthesis(1);

        System.out.println(ts1.size());
        System.out.println(ts2.toString());
    }
}