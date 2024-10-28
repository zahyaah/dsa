import java.util.*; 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>(); 
        if (root == null)
            return list; 
        
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            List<Integer> sublist = new ArrayList<>(); 

            while (size-- > 0) {
                TreeNode temp = queue.poll(); 
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                sublist.add(temp.val);
            }
            list.add(sublist);
        }
        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9); 
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> list = sol.levelOrder(root);
        System.out.println(list.toString());
    }
}