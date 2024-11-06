import java.util.*; 


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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false; 
        
        List<Integer> all = new ArrayList<>(); 
        help(root, 0, all);

        for (int i = 0; i < all.size(); i++)
            if (all.get(i) == targetSum)
                return true; 
        return false; 
    }
    public void help(TreeNode root, int sum, List<Integer> list) {
        if (root.left == null && root.right == null) 
            list.add(sum+root.val);
        if (root.left != null)
            help(root.left, sum + root.val, list);
        if (root.right != null)
            help(root.right, sum + root.val, list);
    }

    public static void main(String[] args) {
        Solution sol =new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int target1 = 5;
        int target2 = 4;
        int target3 = 3;

        System.out.println(sol.hasPathSum(root, target1));
        System.out.println(sol.hasPathSum(root, target2));
        System.out.println(sol.hasPathSum(root, target3));

    }
}