public class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Set<Integer> set = new HashSet<>(); 
        // int MAX = Integer.MIN_VALUE; 
        
        // for (int i: arr) {
        //     set.add(i);
        //     MAX = Math.max(MAX, i);
        // }
        
        // for (int i = 1; i <= MAX; i++) 
        //     if (!set.contains(i))
        //         return i; 
        
        // return MAX < 0 ? 1 : MAX+1;
        // O(N) -> space complexity 
        // optimise it using the cyclic sort. 
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++)
            if (arr[i] != i + 1)
                return i + 1;
            
        

        return n + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] nums1 = new int[] {2, -3, 4, 1, 1, 7}; 
        int[] nums2 = new int[] {5, 3, 2, 5, 1}; 
        int[] nums3 = new int[] {-8, 0, -1, -4, -3}; 

        System.out.println(sol.missingNumber(nums1));
        System.out.println(sol.missingNumber(nums2));
        System.out.println(sol.missingNumber(nums3));
    }
}