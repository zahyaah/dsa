import java.util.*; 

public class Solution {
    public List<List<String>> anagrams(List<String> list) {
        Map<String, List<String>> map = new HashMap<>(); 
        int n = list.size(); 

        for (int i = 0; i < n; i++) {
            char[] arr = list.get(i).toCharArray(); 
            Arrays.sort(arr);

            String wow = new String(arr);

            if (!map.containsKey(wow)) {
                map.put(wow, new ArrayList<>());
            }
            map.get(wow).add(list.get(i));
        }
        
        List<List<String>> result = new ArrayList<>(map.values());
        Collections.sort(result, (a, b) -> a.get(0).compareTo(b.get(0))); // in lexicographical order
        
        return result; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        List<String> list1 = new ArrayList<>(Arrays.asList("act", "god", "cat", "dog", "tac"));
        List<String> list2 = new ArrayList<>(Arrays.asList("no", "on", "is"));

        System.out.println(sol.anagrams(list1).toString());
        System.out.println(sol.anagrams(list2).toString());;
    }
}