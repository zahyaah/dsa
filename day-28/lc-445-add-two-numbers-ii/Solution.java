class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int val) {
        this.val = val; 
        this.next = null; 
    }
}
public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null; 
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public ListNode add(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0); 
        ListNode current = dum;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { 
                sum += l1.val; 
                l1 = l1.next; 
            }
            if (l2 != null) { 
                sum += l2.val; 
                l2 = l2.next; 
            }
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }
        return dum.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode sum = add(l1, l2);
        
        return reverse(sum);
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head = new ListNode(7);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);

        ListNode lead = new ListNode(5);
        lead.next = new ListNode(6);
        lead.next.next = new ListNode(4);

        ListNode result = sol.addTwoNumbers(head, lead);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next; 
        }
    }
}