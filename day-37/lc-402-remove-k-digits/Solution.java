import java.util.*; 

public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }

            stack.offerLast(c);
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollFirst());
        
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String num = "1432219"; 
        int k = 3;
        System.out.println(sol.removeKdigits(num, k));
    }
}