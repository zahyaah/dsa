class TreeNode {
    int val; 
    TreeNode left, right; 

    public TreeNode(int value) {
        this.val = value; 
        this.left = null; 
        this.right = null; 
    }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true; 
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true; 
        
        if (left == null || right == null || left.val != right.val)
            return false; 
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(sol.isSymmetric(root));
    }
}