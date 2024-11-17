import java.util.*; 

public class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') 
                    stack.push(num);
                else if (sign == '-') 
                    stack.push(-num);
                else if (sign == '*') 
                    stack.push(stack.pop() * num);
                else if (sign == '/')
                    stack.push(stack.pop() / num);
                
                num = 0;
                sign = c;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "3+2*2"; 
        String s2 = "  3/2  ";
        String s3 = "  3+5 / 2  ";
        System.out.println(sol.calculate(s1));
        System.out.println(sol.calculate(s2));
        System.out.println(sol.calculate(s3));
    }
}