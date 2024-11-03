class ListNode {
    int val; 
    ListNode next; 

    public ListNode(int value) {
        this.val = value; 
        this.next = null; 
    }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false; 
        
        ListNode temp = head; 

        ListNode slow = head; 
        ListNode fast = head; 
        
        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        // slow is pointing to the middle now
        // reverse it 
        ListNode secondHalf = reverse(head);
        ListNode firstHalf = head; // not really half lol 

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false; 

            firstHalf = firstHalf.next; 
            secondHalf = secondHalf.next; 
        }
        return true; 
    }
    public ListNode reverse(ListNode head) {
        ListNode current = head; 
        ListNode prev = null; 

        while (current != null) {
            ListNode next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        }

        return prev; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(sol.isPalindrome(head));

        ListNode again = new ListNode(1);
        again.next = new ListNode(2);
        
        System.out.println(sol.isPalindrome(again));
    }
}