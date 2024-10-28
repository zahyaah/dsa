// link - https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
public class Solution {
    public String smallestWindow(String s, String p) {
        int n = s.length(), m = p.length(); 
        int[] freqS = new int[256];
        int[] freqP = new int[256];

        for (int i = 0; i < m; i++)
            freqP[p.charAt(i)]++; 
        
        int start = 0, end = 0, count = 0, startIndex = -1, minWin = Integer.MAX_VALUE; 

        while (end < n) {
            char c = s.charAt(end);
            freqS[c]++; 

            if (freqS[c] <= freqP[c])
                count++; 
            
            while (count == m) {
                if (end-start+1 < minWin) {
                    minWin = end-start+1; 
                    startIndex = start; 
                }
                char checkOnce = s.charAt(start);
                freqS[checkOnce]--; 

                if (freqS[checkOnce] < freqP[checkOnce])
                    count--; 

                start++; 
            }

            end++; 
        }

        return startIndex == -1 ? "-1" : s.substring(startIndex, startIndex+minWin);
    }
    public static void main(String[] args) {
        Solution sol= new Solution(); 

        String ts1_1 = "timetopractice";
        String ts1_2 = "toc";

        String ts2_1 = "zoomlazapzo";
        String ts2_2 = "oza";

        String ts3_1 = "zoom";
        String ts3_2 = "zooe";

        System.out.println(sol.smallestWindow(ts1_1, ts1_2));
        System.out.println(sol.smallestWindow(ts2_1, ts2_2));
        System.out.println(sol.smallestWindow(ts3_1, ts3_2));
    }
}