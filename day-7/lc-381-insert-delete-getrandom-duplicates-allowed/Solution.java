// link - https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
import java.util.*; 

class RandomizedCollection {
    List<Integer> list; 
    Map<Integer, Integer> map; 
    Random rand; 

    public RandomizedCollection() {
        list = new ArrayList<>(); 
        map = new HashMap<>(); 
        rand = new Random();     
    }
    
    public boolean insert(int val) {
        boolean check = !map.containsKey(val);
        map.put(val, map.getOrDefault(val, 0)+1);
        list.add(val);

        return check; 
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false; 
        int count = map.get(val);
        if (count == 1)
            map.remove(val);
        else 
            map.put(val, count-1);

        list.remove((Integer)val); // removes the FIRST occurrence only 
        return true; 
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size())); // O(1) ez
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection(); 
        
        System.out.println("INSERTIONS");
        System.out.println(rc.insert(10)); // first, so returns true
        System.out.println(rc.insert(10)); // appears again- returns false 
        System.out.println(rc.insert(20)); // first true
        System.out.println(rc.insert(20)); // second time, return false
        System.out.println(rc.insert(30)); // returns true

        System.out.println("DELETIONS");
        System.out.println(rc.remove(40));
        System.out.println(rc.remove(20));

        System.out.println("RANDOM");
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
    }
}