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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        while (node != null) {

            if (node.left != null) {
                TreeNode rightMost = node.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5); 
        root.right.right = new TreeNode(6);

        sol.flatten(root);

        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right; 
        }

    }
}