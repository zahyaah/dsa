import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks)
            freq[t - 'A']++;
        
        Arrays.sort(freq);

        int maxFreq = freq[25]; 
        int count = 1; 

        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq)
                count++;
            else 
                break; 
        }

        int intervals = (maxFreq - 1) * (n + 1) + count;
        return Math.max(intervals, tasks.length);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        // Test cases
        char[][] tasksArray = {
            {'A', 'A', 'A', 'B', 'B', 'B'},
            {'A', 'C', 'A', 'B', 'D', 'B'},
            {'A', 'A', 'A', 'B', 'B', 'B'},
        };
        int[] nValues = {2, 1, 3};

        for (int i = 0; i < tasksArray.length; i++) {
            int result = sol.leastInterval(tasksArray[i], nValues[i]);
            System.out.println("Tasks: " + Arrays.toString(tasksArray[i]) + ", n: " + nValues[i] + " => Intervals: " + result);
        }
    }
}