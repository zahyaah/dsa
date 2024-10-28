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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>(); 
        if (root == null) return list; 

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); 

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll(); 

                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                
                if (i == size-1)
                    list.add(temp.val);
            }
        }
        return list; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> result = sol.rightSideView(root);
        System.out.println(result.toString());
    }
}