class TreeNode {
    int val; 
    TreeNode left, right; 
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; 
        this.left = left; 
        this.right = right; 
    }
}
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0; 
        
        int left = maxDepth(root.left); 
        int right = maxDepth(root.right);

        return Math.max(left, right)+1; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.left = left; 
        root.right = right; 

        System.out.println(sol.maxDepth(root));
    }
}