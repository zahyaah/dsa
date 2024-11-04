import java.util.*; 

public class Solution {
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        Stack<Integer> stack = new Stack<>();
        int n = s.length(); 
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if (stack.size() >= 2) { 
                    int first = stack.pop(); 
                    int second = stack.pop(); 
                    
                    switch (c) {
                        case '+':
                            stack.push(second+first);
                            break; 
                        case '-':
                            stack.push(second-first);
                            break; 
                        case '/':
                            stack.push(second/first);
                            break; 
                        case '*':
                            stack.push(second*first);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator: " + c); 
                    }
                } else {
                    throw new IllegalArgumentException("Insufficient operands in stack");
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    
        return stack.pop(); 
    }
    public static void main(String[] args) {
        String ts1 = "231*+9-";
        String ts2 = "123+*8-";

        System.out.println(evaluatePostFix(ts1)); 
        System.out.println(evaluatePostFix(ts2)); 
    }
}