class Node {
    int data; 
    Node next; 
    public Node(int value) {
        this.data = value; 
        this.next = null; 
    }
}

public class Solution {
    static final int MOD = 1000000007;
    public long multiplyTwoLists(Node first, Node second) {
        long one = 0; 
        long two = 0; 
        
        Node temp1 = first; 
        while (temp1 != null) {
            one = ((one*10)+temp1.data)%MOD; 
            temp1 = temp1.next; 
        }
        
        temp1 = second; 
        while (temp1 != null) {
            two = ((two*10)+temp1.data)%MOD; 
            temp1 = temp1.next; 
        }
        
        return (one*two)%MOD; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        
        Node first = new Node(3);
        first.next = new Node(2);
        Node second = new Node(2);

        long result = sol.multiplyTwoLists(first, second);
        System.out.println(result);
    }
}