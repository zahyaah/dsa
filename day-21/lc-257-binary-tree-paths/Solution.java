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
    public void help(TreeNode root, String rasta, List<String> list) {
        if (root.left == null && root.right == null) // leaf node
            list.add(rasta + root.val);
        if (root.left != null)
            help(root.left, rasta + root.val + "->", list);
        if (root.right != null)
            help(root.right, rasta + root.val + "->", list);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>(); 
        if (root == null)
            return list; 
        
        help(root, "", list);
        return list; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(sol.binaryTreePaths(root).toString());
    }

}