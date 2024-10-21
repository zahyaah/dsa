public class Solution {
    public void printDuplicates(String s) {
        int[] freq = new int[256];
        char[] arr = s.toCharArray();

        for (char ch: arr) 
            freq[ch]++; 
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 1) {
                System.out.println((char)i + ", " + freq[i]);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "test string";
        sol.printDuplicates(s1);

        System.out.println();
        String s2 = "zaydahmed";
        sol.printDuplicates(s2);
    }
}