class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int value) {
        this.val = value; 
        this.next = null; 
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA; 
        ListNode second = headB; 

        while (first != second) {
            // the switch is important 
            first = (first == null) ? headB : first.next; 
            second = (second == null) ? headA : second.next; 
        }

        return first; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // Create listA: [4, 1, 8, 4, 5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;  

        // Create listB: [5, 6, 1, 8, 4, 5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection; 

        ListNode result = sol.getIntersectionNode(headA, headB);
        ListNode temp = result; 

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next; 
        }
    }
}