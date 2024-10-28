// link - https://leetcode.com/problems/minimum-window-substring/description/
// same as "Smallest window in a string containing all the characters of another string" of GFG
// the difference is, instead of returning -1, this problem is supposed to return "", when unable to find the valid substring
public class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(); 
        
        int[] freqs = new int[256];
        int[] freqt = new int[256];

        for (int i = 0; i < m; i++)
            freqt[t.charAt(i)]++; 
        
        int start = 0, end = 0, count = 0, startIndex = -1, minWin = Integer.MAX_VALUE; 

        while (end < n) {
            char c = s.charAt(end);
            freqs[c]++; 

            if (freqs[c] <= freqt[c])
                count++; 
            
            while (count == m) {
                if (end-start+1 < minWin) {
                    minWin = end-start+1; 
                    startIndex = start; 
                }
                char check = s.charAt(start);
                freqs[check]--; 

                if (freqs[check] < freqt[check])
                    count--; 
                start++; 
            }

            end++; 
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex+minWin);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "ADOBECODEBANC";
        String b = "ABC";
        System.out.println(sol.minWindow(s, b));

        String a = "a", c = "a";
        System.out.println(sol.minWindow(a, c));

        String l = "a", t = "aa";
        System.out.println(sol.minWindow(l, t));
    }
}