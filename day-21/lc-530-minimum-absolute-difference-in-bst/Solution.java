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
    Integer prev = null; 
    int min = Integer.MAX_VALUE; 

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return -1;

        help(root);
        return min; 
    }
    public void help(TreeNode root) {
        if (root == null)
            return; 
        
        help(root.left); 
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val-prev));
        }
        prev = root.val; 
        help(root.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = sol.getMinimumDifference(root);
        System.out.println(result);
    }
}