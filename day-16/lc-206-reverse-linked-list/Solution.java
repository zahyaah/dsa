class ListNode {
    int val; 
    ListNode next; 
    ListNode(int value)  {
        this.val = value; 
        this.next = null; 
    }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)   
            return head; 
        
        ListNode current = head; 
        ListNode previous = null; 

        while (current != null) {
            ListNode next = current.next; 
            current.next = previous; 
            previous = current; 
            current = next; 
        }

        return previous; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null; 

        ListNode res = sol.reverseList(head);
        ListNode now = res; 
        while (now != null) {
            System.out.println(now.val);
            now = now.next; 
        }
    }
}