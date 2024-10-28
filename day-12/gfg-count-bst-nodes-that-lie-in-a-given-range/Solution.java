class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
public class Solution {
    int getCount(Node root,int l, int h) {
        return solve(root, l, h);
    }
    int solve(Node root, int l, int h) {
        if (root == null)
            return 0;
        
        int count = 0; 
        
        if (root.data >= l && root.data <= h) {
            count = 1; 
        }
        
        count += solve(root.left, l, h);
        count += solve(root.right, l, h);
        
        return count; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        Node root = new Node(10);
        Node left = new Node(5);
        left.left = new Node(1);
        root.left = left; 
        Node right = new Node(50);
        right.left = new Node(40);
        right.right = new Node(100);
        root.right = right; 

        System.out.println(sol.getCount(root, 5, 45));
    }
}