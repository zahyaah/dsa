import java.util.*; 

public class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Set<Integer> seen = new HashSet<>();
        int del = 0;

        for (int f : freq) {
            while (f > 0 && seen.contains(f)) {
                f--;
                del++;
            }

            if (f > 0) 
                seen.add(f);
        }

        return del;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        String s1 = "aab"; 
        System.out.println(sol.minDeletions(s1));

        String s2 = "aaabbbcc";
        System.out.println(sol.minDeletions(s2));
    }
}