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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();    
        inorder(root, list);
        return list; 
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return; 
        inorder(root.left, list); 
        list.add(root.val);
        inorder(root.right, list);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = sol.inorderTraversal(root);
        System.out.println(result.toString());
    }
}