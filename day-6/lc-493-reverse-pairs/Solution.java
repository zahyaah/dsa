// link - https://leetcode.com/problems/reverse-pairs/

// based on merge sort
// solve count inversions gfg once, before solving this 
public class Solution {
    public void merge(int[] nums, int l, int m, int r) {
        int first = m-l+1; 
        int second = r-m; 
        int[] L = new int[first];
        int[] R = new int[second];

        for (int i = 0; i < first; i++)
            L[i] = nums[i+l];
        for (int j = 0; j < second; j++)
            R[j] = nums[m+1+j];
        
        int i = 0, j = 0, k = l; 

        while (i < first && j < second) {
            if (L[i] <= R[j]) 
                nums[k] = L[i++]; 
            else 
                nums[k] = R[j++];
            k++; 
        }

        while (i < first) {
            nums[k] = L[i++];
            k++; 
        }
        while (j < second) {
            nums[k] = R[j++];
            k++; 
        }
    }
    public int countPairs(int[] nums, int l, int m, int r) {
        int count = 0; 
        int end = m+1; 
        for (int i = l; i <= m; i++) {
            while (end <= r && (long)nums[i] > 2*(long)nums[end])
                end++; 
            count += (end-(m+1));
        }
        return count; 
    }
    public int sort(int[] nums, int l, int r) {
        int finalCount = 0; 
        if (l < r) {
            int mid = l + (r-l)/2; 
            finalCount += sort(nums, l, mid);
            finalCount += sort(nums, mid+1, r);
            finalCount += countPairs(nums, l, mid, r);
            merge(nums, l, mid, r);
        }
        return finalCount; 
    }
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] T1 = new int[] {1,3,2,3,1};
        int[] T2 = new int[] {2,4,3,5,1}; 

        int res1 = sol.reversePairs(T1);
        int res2 = sol.reversePairs(T2);

        System.out.println(res1 + " " + res2);
    }
}