class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dumbf = new ListNode(0, head);
        ListNode prev = dumbf;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } 
            else 
                prev = prev.next;
            

            head = head.next;
        }
        return dumbf.next;
    }

    public static void main(String[] args) {
        // Test case 1: Longer list with duplicates
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
        System.out.println("Linked List 1: ");
        printList(head1);
        System.out.print("Test Case 1: ");
        printList(new Solution().deleteDuplicates(head1)); // Expected output: 1 -> 2 -> 3 -> 4

        System.out.println();
        // Test case 2: Longer list without duplicates
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Linked List 2: ");
        printList(head2);
        System.out.print("Test Case 2: ");
        printList(new Solution().deleteDuplicates(head2)); // Expected output: 1 -> 2 -> 3 -> 4 -> 5
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}