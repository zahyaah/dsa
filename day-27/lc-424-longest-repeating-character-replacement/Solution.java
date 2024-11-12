public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0;
        
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);

            count[c- 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);
            
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "ABAB"; 
        int k1 = 2; 
        System.out.println(sol.characterReplacement(s1, k1));

        String s2 = "AABABBA"; 
        int k2 = 1; 
        System.out.println(sol.characterReplacement(s2, k2));
    }
}