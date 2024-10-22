// link - https://leetcode.com/problems/reverse-words-in-a-string/

public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        int start = 0, end = arr.length-1;

        while (start <= end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp; 
            start++; 
            end--; 
        }

        StringBuilder sb = new StringBuilder(); 
        
        for (String str: arr) {
            if (str != "") {
                sb.append(str);
                sb.append(" ");
            }
        }

        return sb.toString().trim(); 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        String res1 = sol.reverseWords(s1);
        String res2 = sol.reverseWords(s2);
        String res3 = sol.reverseWords(s3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}