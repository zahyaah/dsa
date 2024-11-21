import java.util.*; 

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        int currentNum = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) 
                currentNum = currentNum * 10 + (ch - '0');
            else if (ch == '[') {
                countStack.push(currentNum);
                stringStack.push(current);
                currentNum = 0;
                current = new StringBuilder();
            } 
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for (int i = 0; i < repeat; i++) 
                    prev.append(current);

                current = prev;
            } 
            else 
                current.append(ch);
        }
        
        return current.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "3[a]2[bc]"; 
        System.out.println(sol.decodeString(s1));

        String s2 = "3[a2[c]]";
        System.out.println(sol.decodeString(s2));
    }
}