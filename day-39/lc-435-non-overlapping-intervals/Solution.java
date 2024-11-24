import java.util.*; 
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length; 
        if (n == 0) 
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int rm = 0, end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < end)
                rm++;
            else 
                end = intervals[i][1];
        }

        return rm;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals1)); 

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println(solution.eraseOverlapIntervals(intervals2)); 

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals3)); 
    }
}