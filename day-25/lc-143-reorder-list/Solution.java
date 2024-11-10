// SAME AS GFG'S REORDER LIST

// TC - O(N)
// SC - O(1)
class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int val) {
        this.val = val; 
        this.next = null; 
    }
}
class Solution {
    public void reorderList(ListNode head) {
        // divide, reverse the second half and merge- ez 
        ListNode slow = head; 
        ListNode fast = head; 
        
        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        
        ListNode secondPart = reverse(slow.next); 
        slow.next = null; 
        
        ListNode firstPart = head; 
        
        while (secondPart != null) {
            ListNode nextFirst = firstPart.next; 
            firstPart.next = secondPart; 

            firstPart = secondPart; 
            secondPart = nextFirst; 
        }
    }
    ListNode reverse(ListNode head) {
        ListNode temp = head; 
        ListNode prev = null; 
        
        while (temp != null) {
            ListNode next = temp.next; 
            temp.next = prev; 
            prev = temp; 
            temp = next;  
        }
        
        return prev; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        

        sol.reorderList(head);

        ListNode temp = head; 

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next; 
        }
    }
}