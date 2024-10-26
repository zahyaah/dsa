// link - https://leetcode.com/problems/linked-list-cycle/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 

            if (slow == fast)
                return true; 
        }
        return false; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(3);
        ListNode temp1 = new ListNode(2);
        head.next = temp1; 
        ListNode temp2 = new ListNode(0);
        temp1.next = temp2; 
        ListNode temp3 = new ListNode(-4);
        temp2.next = temp3;
        temp3.next = temp1;  

        System.out.println(sol.hasCycle(head));
    }
}