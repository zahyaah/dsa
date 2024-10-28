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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>(); 
        if (root == null)
            return list; 
        
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        boolean alternate = false; 

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            List<Integer> sublist = new ArrayList<>(); 

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll(); 

                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                
                sublist.add(temp.val);
            }
            if (alternate) {
                Collections.reverse(sublist);
            }
            list.add(sublist);
            alternate = !alternate; 
        }

        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.left = left; 
        root.right = right; 

        List<List<Integer>> result = sol.zigzagLevelOrder(root);
        System.out.println(result.toString());
    }
}