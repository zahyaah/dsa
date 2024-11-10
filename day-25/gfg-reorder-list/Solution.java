// TC - O(n)
// SC - O(1)
class Node {
    int data; 
    Node next; 

    public Node(int val) {
        this.data = val; 
        this.next = null;
    }
}

public class Solution {
    void reorderlist(Node head) {
        // divide, reverse the second half and merge- ez 
        Node slow = head; 
        Node fast = head; 
        
        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        
        Node secondPart = reverse(slow.next); 
        slow.next = null; 
        
        Node firstPart = head; 
        
        while (secondPart != null) {
            Node nextFirst = firstPart.next; 
            firstPart.next = secondPart; 

            firstPart = secondPart; 
            secondPart = nextFirst; 
        }
    }
    Node reverse(Node head) {
        Node temp = head; 
        Node prev = null; 
        
        while (temp != null) {
            Node next = temp.next; 
            temp.next = prev; 
            prev = temp; 
            temp = next;  
        }
        
        return prev; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        Node head = new Node(1);
        head.next = new Node(7);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        

        sol.reorderlist(head);

        Node temp = head; 

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; 
        }
    }
}