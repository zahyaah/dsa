// link - https://leetcode.com/problems/maximum-product-of-three-numbers/
// description isn't clear
// duplicates can be included in the input array
public class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE; 
        int second = Integer.MIN_VALUE; 
        int third = Integer.MIN_VALUE; 
        int minFirst = Integer.MAX_VALUE; 
        int minSecond = Integer.MAX_VALUE; 
        
        for (int num : nums) {
            if (num >= first) {
                third = second; 
                second = first; 
                first = num; 
            } else if (num >= second) {
                third = second; 
                second = num; 
            } else if (num > third) {
                third = num; 
            }

            if (num <= minFirst) {
                minSecond = minFirst; 
                minFirst = num; 
            } else if (num < minSecond) {
                minSecond = num;
            }
        }

        return Math.max(first * second * third, first * minFirst * minSecond);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] ts1 = new int[] {1,2,3}; 
        int[] ts2 = new int[] {1,2,3,4}; 
        int[] ts3 = new int[] {-1,-2,-3}; 

        System.out.println(sol.maximumProduct(ts1) + " " + sol.maximumProduct(ts2) + " " + sol.maximumProduct(ts3));
    }
}