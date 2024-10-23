// link - https://leetcode.com/problems/simplify-path/description/

import java.util.*; 
public class Solution {
    public String simplifyPath(String path) {
        String[] store = path.split("/");
        Stack<String> stack = new Stack<>(); 

        for (String file: store) {
            if (file.equals("..")) {
                if (!stack.isEmpty()) 
                    stack.pop(); 
            }
            if (!file.equals("") && !file.equals(".") && !file.equals(".."))
                stack.push(file);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, '/' + stack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "/home/";
        String s2 = "/home//foo/";
        String s3 = "/home/user/Documents/../Picture";
        String s4 = "/../";
        String s5 = "/.../a/../b/c/../d/.";


        System.out.println(sol.simplifyPath(s1));
        System.out.println(sol.simplifyPath(s2));
        System.out.println(sol.simplifyPath(s3));
        System.out.println(sol.simplifyPath(s4));
        System.out.println(sol.simplifyPath(s5));

        // System.out.println(Arrays.toString(s1.split("/")));
        // System.out.println(Arrays.toString(s2.split("/")));
        // System.out.println(Arrays.toString(s3.split("/")));
        // System.out.println(Arrays.toString(s4.split("/")));
        // System.out.println(Arrays.toString(s5.split("/")));
        // -- OUTPUT --
        // [, home]
        // [, home, , foo]
        // [, home, user, Documents, .., Picture]
        // [, ..]
        // [, ..., a, .., b, c, .., d, .]
    }
}