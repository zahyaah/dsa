import java.util.*; 

public class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
        Arrays.sort(arr1); 
        Arrays.sort(arr2);
        int n = arr1.length; 
        
        for (int i = 0; i < n; i++) {
            if (arr1[i]+arr2[n-1-i] >= k)
                continue; 
            else 
                return false; 
        }
        return true; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] arr1 = new int[] {2,1,3};
        int[] arr2 = new int[] {7,8,9};
        int k = 10; 
        System.out.println(sol.isPossible(k, arr1, arr2));

        int[] brr1 = new int[] {1,2,2,1}; 
        int[] brr2 = new int[] {3,3,3,4}; 
        int b = 5;
        System.out.println(sol.isPossible(b, brr1, brr2));
    }
}