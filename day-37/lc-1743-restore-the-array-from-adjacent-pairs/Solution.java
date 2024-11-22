import java.util.*; 

public class Solution {
    public int[] restoreArray(int[][] pairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : pairs) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            map.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (e.getValue().size() == 1) {
                start = e.getKey();
                break;
            }
        }

        int n = pairs.length + 1, idx = 0, cur = start;
        int[] res = new int[n];
        Set<Integer> vis = new HashSet<>();
        while (idx < n) {
            res[idx++] = cur;
            vis.add(cur);

            for (int next : map.get(cur)) {
                if (!vis.contains(next)) {
                    cur = next;
                    break;
                }
            }
        }


        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[][] nums = new int[][] {
            {2,1}, {3,4}, {3,2}
        }; 
        int[] result = sol.restoreArray(nums);
        System.out.println(Arrays.toString(result));
    }
}