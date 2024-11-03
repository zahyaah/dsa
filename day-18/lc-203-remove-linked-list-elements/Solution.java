class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int value) {
        this.val = value; 
        this.next = null; 
    }
}
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head; 
        
        ListNode store = new ListNode(0);
        store.next = head; 
        ListNode temp = store; 

        while (temp.next != null) {
            if (temp.next.val == val)
                temp.next = temp.next.next; 
            else
                temp = temp.next; 
        }
        return store.next; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode temp = sol.removeElements(head, 6);

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next; 
        }
    }
}