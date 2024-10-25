// link - https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
import java.util.*; 

public class Solution {
    public int findPair(int n, int x, int[] arr) {
        Set<Integer> set = new HashSet<>(); 
        
        for (int num: arr) {
            if (set.contains(num+x) || set.contains(num-x))
                return 1; 
            set.add(num);
        }
        return -1; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        int ts1 = sol.findPair(6, 78, new int[] {5,20,3,2,5,80});
        int ts2 = sol.findPair(5, 45, new int[] {90,70,20,80,50});

        System.out.println(ts1 + " " + ts2);
    }
}