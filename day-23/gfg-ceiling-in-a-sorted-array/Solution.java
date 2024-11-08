public class Solution {
    public static int ceiling(int[] nums, int x) {
        int low = 0, high = nums.length; 

        while (low < high) {
            int mid = low + (high-low)/2; 

            if (nums[mid] == x)
                return mid; 
            if (nums[mid] < x)
                low = mid+1; 
            else 
                high = mid; 
        }
        return low; 
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 8, 10, 10, 12, 19};
        int size = arr.length; 
        int x = 0; 
        int m = 1; 
        int n = 5; 
        int l = 20;

        int sol1 = ceiling(arr, x)< size ? arr[ceiling(arr, x)] : -1;
        int sol2 = ceiling(arr, m) < size ? arr[ceiling(arr, m)] : -1;
        int sol3 = ceiling(arr, n) < size ? arr[ceiling(arr, n)] : -1;
        int sol4 = ceiling(arr, l) < size ? arr[ceiling(arr, l)] : -1;

        System.out.println(sol1);
        System.out.println(sol2);
        System.out.println(sol3);
        System.out.println(sol4);
    }
}