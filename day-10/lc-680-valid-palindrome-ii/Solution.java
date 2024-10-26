// link - https://leetcode.com/problems/valid-palindrome-ii/description/
public class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length(); 
        int start = 0, end = n-1; 

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                // the part which is not in the range, is already verified 
                // and if characters differ, check if skipping one makes a palindrome
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }
            start++; end--; 
        }
        return true; 
    }
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false; 
            start++; end--; 
        }
        return true; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        System.out.println(sol.validPalindrome("aba"));
        System.out.println(sol.validPalindrome("abca"));
        System.out.println(sol.validPalindrome("abc"));
    }
}