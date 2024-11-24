public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gash = 0; 
        int c = 0; 
        int tank = 0, start = 0;
        int n = gas.length; 

        for (int i = 0; i < n; i++) {
            gash += gas[i];
            c += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return gash >= c ? start : -1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] gas = new int[] {1,2,3,4,5}; 
        int[] cost = new int[] {3,4,5,1,2}; 
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }
}