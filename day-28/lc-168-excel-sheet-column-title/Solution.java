public class Solution {
    public String convertToTitle(int num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            num--; 
            sb.insert(0, (char) ('A' + num % 26));
            num /= 26;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        System.out.println(sol.convertToTitle(1));
        System.out.println(sol.convertToTitle(28));
        System.out.println(sol.convertToTitle(701));
    }
}