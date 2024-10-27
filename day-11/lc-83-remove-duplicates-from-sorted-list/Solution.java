class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head; 
        
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next; 
            } 
            else {
                temp = temp.next; 
            }
        }
        return head; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode result = sol.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next; 
        }
    }
}