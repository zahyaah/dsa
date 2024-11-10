class Node {
    int data; 
    Node next; 

    public Node(int val) {
        this.data = val; 
        this.next = null; 
    }
}

public class Solution {
    Node divide(Node head) {
        Node mainEven = new Node(0);
        Node even = mainEven; 
        
        Node mainOdd = new Node(0);
        Node odd = mainOdd; 
        
        Node temp = head; 
        while (temp != null) {
            if ((temp.data&1) == 1) {
                odd.next = temp; 
                odd = odd.next; 
            } else {
                even.next = temp; 
                even = even.next; 
            }
            
            temp = temp.next; 
        }
        
        odd.next = null; 
        even.next = mainOdd.next; 
        
        return mainEven.next; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        Node head = new Node(17); 
        head.next = new Node(15); 
        head.next.next = new Node(8); 
        head.next.next.next = new Node(9); 
        head.next.next.next.next = new Node(2); 
        head.next.next.next.next.next = new Node(4); 
        head.next.next.next.next.next.next = new Node(6); 

        Node result = sol.divide(head);
        Node temp = result; 

        while (temp != null) {
            System.out.print(temp.data + " -> "); 
            temp = temp.next; 
        }
    }
}