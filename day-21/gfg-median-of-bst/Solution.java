import java.util.*; 

class Node {
    int data; 
    Node left, right; 

    public Node(int value) {
        this.data = value; 
        this.left = null; 
        this.right = null; 
    }
}
public class Solution {
    public static float findMedian(Node root)
    {
        List<Integer> list = new ArrayList<>(); 
        if (root == null)
            return -1; 
            
        inorder(root, list);
        int n = list.size(); 
        int index = n/2; 
        
        if ((n&1) == 1)
            return (float)list.get(index); 
        else {
            return (list.get(index)+list.get(index-1))/2.0f; 
        }
    }
    public static void inorder(Node root, List<Integer> list) {
        if (root == null)
            return; 
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.right = new Node(4);
        root.left.left = new Node(1);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println(findMedian(root));
    }
}