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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root; 

        TreeNode temp = root.left;
        root.left = root.right; 
        root.right = temp; 

        invertTree(root.left);
        invertTree(root.right);

        return root; 
    }
}