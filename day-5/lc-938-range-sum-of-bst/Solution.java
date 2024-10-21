// link - https://leetcode.com/problems/range-sum-of-bst/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null)
            return 0; 
        int sum = 0; 

        if (root.val >= l) 
            sum += rangeSumBST(root.left, l, r);
        if (root.val >= l && root.val <= r)
            sum += root.val; 
        if (root.val <= r)
            sum += rangeSumBST(root.right, l, r);

        return sum; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        // BST 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);

        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);

        root1.right.right = new TreeNode(18);

        // BST 2 
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);

        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);

        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);

        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);

        int sum1 = sol.rangeSumBST(root1, 7, 15);
        int sum2 = sol.rangeSumBST(root2, 6, 10);

        System.out.println(sum1 + " " + sum2);
    }
}