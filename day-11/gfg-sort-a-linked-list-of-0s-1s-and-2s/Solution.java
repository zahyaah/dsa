class Node {
    int data; 
    Node next; 

    public Node(int data) {
        this.data = data; 
        this.next = null; 
    }
}
public class Solution {
    public Node segregate(Node head) {
        Node zero = new Node(0);
        Node one = new Node(0);
        Node two = new Node(0);
        
        // pointers to the above original nodes 
        Node tz = zero; 
        Node to = one; 
        Node tt = two; 
        
        Node temp = head; 
        
        while (temp != null) {
            if (temp.data == 0) {
                tz.next = temp; 
                tz = tz.next; 
            }
            if (temp.data == 1) {
                to.next = temp; 
                to = to.next; 
            }
            if (temp.data == 2) {
                tt.next = temp; 
                tt = tt.next; 
            }
            temp = temp.next; 
        }
        
        // joining each temp pointer
        tz.next = (one.next != null) ? one.next : two.next; 
        to.next = two.next; 
        tt.next = null; 
        
        head = zero.next; 
        
        return head; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);


        Node result = sol.segregate(head);

        while (result != null) {
            System.out.println(result.data);
            result = result.next; 
        }
    }
}