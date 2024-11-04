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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q; 
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode boot = new TreeNode(1);
        boot.left = new TreeNode(2);
        boot.right = new TreeNode(3);

        System.out.println(sol.isSameTree(root, boot));
    }
}