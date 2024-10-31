import java.util.*; 
class TreeNode {
    int val; 
    TreeNode left, right; 

    public TreeNode(int val) {
        this.val = val; 
        this.left = null; 
        this.right = null; 
    }
}

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
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0; 
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        // parent -> i
        // left -> 2*i + 1
        // right -> 2*i + 2 
        int MAX = Integer.MIN_VALUE; 

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            int first = 0, last = 0; 
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pp = queue.poll(); 
                TreeNode sep = pp.getKey(); 
                int index = pp.getValue(); 

                if (sep.left != null)
                    queue.offer(new Pair<>(sep.left, (2*index)+1));
                if (sep.right != null)
                    queue.offer(new Pair<>(sep.right, (2*index)+2));
                
                if (i == 0)
                    first = index; 
                if (i == size-1)
                    last = index; 
            }
            MAX = Math.max(MAX, last-first+1);
        }
        return MAX; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(sol.widthOfBinaryTree(root));

        TreeNode koop = new TreeNode(1);
        koop.left = new TreeNode(3);
        koop.right = new TreeNode(2);
        koop.left.left = new TreeNode(5);
        koop.left.left.left = new TreeNode(6);
        koop.right.right = new TreeNode(9);
        koop.right.right.left = new TreeNode(7); 
        System.out.println(sol.widthOfBinaryTree(koop));
    }
}