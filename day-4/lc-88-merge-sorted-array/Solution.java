import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1; 
        
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[last] = nums1[m-1]; 
                m--; 
            } else {
                nums1[last] = nums2[n-1]; 
                n--; 
            }
            last--; 
        }
        
        while (n > 0) {
            nums1[last] = nums2[n-1];
            n--; 
            last--; 
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        int[] ts1_1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] ts1_2 = {2, 5, 6};
        int n1 = 3;
        sol.merge(ts1_1, m1, ts1_2, n1);

        System.out.println(Arrays.toString(ts1_1));

        int[] ts2_1 = {1};
        int m2 = 1;
        int[] ts2_2 = {};
        int n2 = 0;
        sol.merge(ts2_1, m2, ts2_2, n2);

        System.out.println(Arrays.toString(ts2_1));

        int[] ts3_1 = {0};
        int m3 = 0;
        int[] ts3_2 = {1};
        int n3 = 1;
        sol.merge(ts3_1, m3, ts3_2, n3);

        System.out.println(Arrays.toString(ts3_1));
    }
}