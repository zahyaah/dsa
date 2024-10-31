// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// time complexity - O(nlog n) 
// space complexity - O(n)
import java.util.*; 
class Pair<M, T> {
    M a; 
    T b; 
    Pair(M m, T n) {
        this.a = m; 
        this.b = n; 
    }
    public M getKey() {
        return this.a; 
    }

    public T getValue() {
        return this.b; 
    }
}
class TreeNode {
    int val; 
    TreeNode left, right; 
    TreeNode(int val) {
        this.val = val; 
        this.left = null; 
        this.right = null; 
    }
}
class NodePair {
    TreeNode node; 
    Pair<Integer, Integer> pair; 
    NodePair(TreeNode root, Pair<Integer, Integer> pari) {
        this.node = root; 
        this.pair = pari; 
    }
}
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>(); 
        if (root == null)
            return list; 
        
        Queue<NodePair> queue = new LinkedList<>(); 
        List<NodePair> store = new ArrayList<>(); 

        queue.offer(new NodePair(root, new Pair(0, 0)));

        while (!queue.isEmpty()) {
            int size = queue.size(); 

            for (int i = 0; i < size; i++) {
                NodePair temp = queue.poll(); 
                store.add(temp);
                TreeNode N = temp.node; 
                Pair<Integer, Integer> P = temp.pair; 

                if (N.left != null)
                    queue.offer(new NodePair(N.left, new Pair(P.getKey()+1, P.getValue()-1))); 
                if (N.right != null)
                    queue.offer(new NodePair(N.right, new Pair(P.getKey()+1, P.getValue()+1))); 
            }
        }
        store.sort((a, b) -> {
            if (!a.pair.getValue().equals(b.pair.getValue())) {
                return a.pair.getValue() - b.pair.getValue(); // Sort by column (vertical)
            } else if (!a.pair.getKey().equals(b.pair.getKey())) {
                return a.pair.getKey() - b.pair.getKey(); // Sort by row (horizontal)
            } else {
                return a.node.val - b.node.val; // Sort by node value if same column and row
            }
        });
        Map<Integer, List<Integer>> map = new HashMap<>(); 

        for (NodePair every: store) {
            TreeNode um = every.node; 
            Pair<Integer, Integer> p = every.pair;    
            int key = p.getKey(); 
            int value = p.getValue(); 

            if (!map.containsKey(value)) {
                List<Integer> li = new ArrayList<>(); 
                li.add(um.val);
                map.put(value, li);
            } else {
                List<Integer> getLi = map.get(value);
                getLi.add(um.val);
            }
        }

        Map<Integer, List<Integer>> sorted = new TreeMap<>(map); 
        list.addAll(sorted.values());

        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans1 = sol.verticalTraversal(root);
        System.out.println(ans1.toString());

        TreeNode boot = new TreeNode(1);
        boot.left = new TreeNode(2);
        boot.right = new TreeNode(3); 
        boot.left.left = new TreeNode(4);
        boot.left.right = new TreeNode(5);
        boot.right.left = new TreeNode(6);
        boot.right.right = new TreeNode(7);
        
        List<List<Integer>> ans2 = sol.verticalTraversal(boot);
        System.out.println(ans2.toString());
    }
}