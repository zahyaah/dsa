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

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> store = new ArrayList<>(); 
        storeInorder(root, store);

        return store.get(k-1);
    }
    public void storeInorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        storeInorder(root.left, list);
        list.add(root.val);
        storeInorder(root.right, list);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(sol.kthSmallest(root, 1));
    }
}