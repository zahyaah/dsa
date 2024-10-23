// link - https://leetcode.com/problems/longest-common-prefix/

import java.util.*; 
public class Solution {
    public String longestCommonPrefix(String[] bhai) {
        Arrays.sort(bhai);
        int n = bhai.length;
        StringBuffer sb = new StringBuffer(); 
        String start = bhai[0], end = bhai[n-1];

        for (int i = 0, j = 0; i < start.length(); i++, j++) {
            if (start.charAt(i) != end.charAt(j))
                return sb.toString(); 
            sb.append(start.charAt(i));
        }

        return sb.toString(); 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String res1 = sol.longestCommonPrefix(new String[] {"flower","flow","flight"});
        String res2 = sol.longestCommonPrefix(new String[] {"dog","racecar","car"});

        System.out.println(res1); 
        System.out.println(res2);
    }
}