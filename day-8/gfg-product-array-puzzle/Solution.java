// link - https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
// on leetcode? - https://leetcode.com/problems/product-of-array-except-self/
import java.util.Arrays;

public class Solution {
    public long[] productExceptSelf(int nums[]) {
        int n = nums.length; 
        long[] result = new long[n]; 
        long prefixProduct = 1, postfixProduct = 1; 
        
        // prefix product for an element i
        // is the product of all the elements before i 
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct; 
            prefixProduct *= nums[i]; 
        }
        
        // postfix product for an element j 
        // is the product of all the elements after j
        for (int j = n-1; j >= 0; j--) {
            result[j] *= postfixProduct; 
            postfixProduct *= nums[j]; 
        }
        
        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {10, 3, 5, 6, 2}; 
        int[] ts2 = new int[] {12, 0}; 

        long[] res1 = sol.productExceptSelf(ts1);
        long[] res2 = sol.productExceptSelf(ts2);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
}