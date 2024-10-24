import java.util.*; 
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        String res1 = solve(s); 
        String res2 = solve(t);
        return res1.equals(res2);
    }
    public String solve(String s) {
        char[] arr = s.toCharArray(); 
        StringBuffer sb = new StringBuffer(); 
        Stack<Character> stack = new Stack<>(); 

        for (char ch: arr) {
            if (ch != '#') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty())
                    stack.pop(); 
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString(); 
    }
    public static void main(String[] args) {
        Solution sol= new Solution(); 
        
        String s = "ab#c", t = "ad#c";
        System.out.println(sol.backspaceCompare(s, t)); 

        String n = "ab##", m = "c#d#";
        System.out.println(sol.backspaceCompare(n, m));

        String u = "a#c", v = "b";
        System.out.println(sol.backspaceCompare(u, v));
    }
}