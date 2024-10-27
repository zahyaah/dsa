class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head; 
        int length = getLength(head)-1;
        int deci = 0; 

        while (temp != null) {
            deci += (temp.val * Math.pow(2, length--));
            temp = temp.next; 
        }

        return deci; 
    }
    public int getLength(ListNode head) {
        ListNode temp = head; 
        int len = 0; 

        while (temp != null) {
            len++; 
            temp = temp.next; 
        }

        return len; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(1)));
        ListNode head2 = new ListNode(0);

        System.out.println(sol.getDecimalValue(head1));
        System.out.println(sol.getDecimalValue(head2));
    }
}