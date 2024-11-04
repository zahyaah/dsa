import java.util.*; 

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        String operators = "*/+-";

        for (String token: tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                if (stack.size() >= 2) {
                    int first = stack.pop(); 
                    int second = stack.pop(); 

                    switch(token) {
                        case "+" -> stack.push(second+first);
                        case "-" -> stack.push(second-first);
                        case "/" -> stack.push(second/first);
                        case "*" -> stack.push(second*first);
                        default -> throw new IllegalArgumentException("Invalid operator: " + token);
                    }
                } else throw new IllegalArgumentException("Insufficient operands in stack");
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }

        return stack.pop(); 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String[] ts1 = new String[] {"2","1","+","3","*"};
        String[] ts2 = new String[] {"4","13","5","/","+"};
        String[] ts3 = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(sol.evalRPN(ts1));
        System.out.println(sol.evalRPN(ts2));
        System.out.println(sol.evalRPN(ts3));
    }
}