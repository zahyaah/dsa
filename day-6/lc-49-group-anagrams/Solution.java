// link - https://leetcode.com/problems/group-anagrams/
import java.util.*; 
public class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, List<String>> map = new HashMap<>(); 

        for (String word : words) {
            char[] arr = word.toCharArray(); 
            Arrays.sort(arr);
            String hain = new String(arr);
            if (!map.containsKey(hain)) {
                map.put(hain, new ArrayList<>());
            }
            map.get(hain).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        String[] ts1 = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] ts2 = new String[] {""}; 
        String[] ts3 = new String[] {"a"};

        System.out.println(sol.groupAnagrams(ts1).toString());
        System.out.println(sol.groupAnagrams(ts2).toString());
        System.out.println(sol.groupAnagrams(ts3).toString());
    }
}