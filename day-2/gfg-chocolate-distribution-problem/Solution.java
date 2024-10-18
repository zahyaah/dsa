// link - 
import java.util.*; 

public class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int start = 0, end = m-1; 
        long MIN = Long.MAX_VALUE; 
        
        while (end < n) {
            MIN = Math.min(a.get(end)-a.get(start), MIN);
            start++; 
            end++; 
        }
        return MIN; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ArrayList<Integer> ts1 = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        int n1 = 8, m1 = 5;
        long res1 = sol.findMinDiff(ts1, n1, m1);

        ArrayList<Integer> ts2 = new ArrayList<>(Arrays.asList(7, 3, 2, 4, 9, 12, 56));
        int n2 = 7, m2 = 3;
        long res2 = sol.findMinDiff(ts2, n2, m2);

        System.out.println(res1 + " " + res2);
    }
}


// number of students 5
// 1 3 4 7 9 9 12 56 -> sorted
// window of size m will be maintained. max = Math.max(max, nums[end]-nums[start]);

// number of students: 3
// 2 3 4 7 9 12 56