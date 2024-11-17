import java.util.*; 

public class Solution {
    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public Node Bst(int[] pre, int size) {
        if (size == 0) return null;
        Stack<Node> stack = new Stack<>();
        Node root = new Node(pre[0]);
        stack.push(root);

        for (int i = 1; i < size; i++) {
            Node node = new Node(pre[i]);

            if (stack.peek().data > node.data)
                stack.peek().left = node;
            else {
                Node parent = null;
                
                while (!stack.isEmpty() && stack.peek().data < node.data) 
                    parent = stack.pop();
                parent.right = node;
            }
            
            stack.push(node);
        }

        return root;
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        int[] arr = new int[] {40,30,35,80,100}; 
        int a = 5;

        int[] brr = new int[] {40,30,32,35,80,90,100,120}; 
        int b = 8; 

        Node root1 = sol.Bst(arr, a);
        Node root2 = sol.Bst(brr, b);

        System.out.println("Postorder traversal of the first tree: ");
        sol.postorder(root1);
        System.out.println("\nPostorder traversal of the second tree: ");
        sol.postorder(root2);
    }
}