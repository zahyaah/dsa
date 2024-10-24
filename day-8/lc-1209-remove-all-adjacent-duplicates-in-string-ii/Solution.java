// link - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

import java.util.*; 

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        char[] letters = s.toCharArray(); 

        for (char letter: letters) {
            if (!stack.isEmpty() && stack.peek().getKey() == letter) {
                stack.push(new Pair<>(letter, stack.pop().getValue() + 1));
            }
            else {
                stack.push(new Pair<>(letter, 1));
            }
            
            if (stack.peek().getValue() == k) {
                stack.pop();
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (Pair<Character, Integer> pair : stack) {
            result.append(String.valueOf(pair.getKey()).repeat(pair.getValue()));
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String res1 = sol.removeDuplicates("abcd", 2);
        String res2 = sol.removeDuplicates("deeedbbcccbdaa", 3);
        String res3 = sol.removeDuplicates("pbbcggttciiippooaais", 2);

        System.out.println(res1 + " " + res2 + " " + res3);
    }
}