class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int val) {
        this.val = val; 
        this.next = null; 
    }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode see = new ListNode(0);
        see.next = head;
        
        ListNode first = see;
        ListNode second = see;
        
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return see.next;
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        int n = 2; 

        ListNode res = sol.removeNthFromEnd(head, n);
        ListNode temp = res; 

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next; 
        }
    }
}