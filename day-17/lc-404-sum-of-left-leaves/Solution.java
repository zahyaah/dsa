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
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root);
    }
    public int sum(TreeNode root) {
        if (root == null)
            return 0; 
        int sum = 0; 

        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val; 
        sum += sum(root.left)+sum(root.right);
        
        return sum; 
    }
    public static void main(String[] args) {
        Solution sol= new Solution(); 
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20); 
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.sumOfLeftLeaves(root));
    }
}