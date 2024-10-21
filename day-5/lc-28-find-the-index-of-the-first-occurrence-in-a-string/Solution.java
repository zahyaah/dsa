public class Solution {
    public int strStr(String a, String b) {
        int n = a.length(), m = b.length(); 
        if (m > n)
            return -1; 
        
        for (int i = 0; i <= n-m; i++) {
            if (a.substring(i, i+m).equals(b))
                return i; 
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String a1 = "sadbutsad";
        String b1 = "sad";

        String a2 = "leetcode";
        String b2 = "leeto";

        System.out.println(sol.strStr(a1, b1));
        System.out.println(sol.strStr(a2, b2));
    }
}