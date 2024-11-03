class ListNode {
    int val; 
    ListNode next; 
    public ListNode(int value) {
        this.val = value; 
        this.next = null; 
    }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode keep = new ListNode(0);
        ListNode start = keep; 
        ListNode first = list1; 
        ListNode second = list2; 

        while (first != null && second != null) {
            if (first.val <= second.val) {
                start.next = first; 
                first = first.next; 
            } else {
                start.next = second; 
                second = second.next; 
            }
            start = start.next; 
        }

        while (first != null) {
            start.next = first;
            start = start.next;  
            first = first.next;
        }
        while (second != null) {
            start.next = second;
            start = start.next;  
            second = second.next;
        }

        return keep.next; 
    }
    public static void main(String[] args) {
        Solution sol = new Solution(); 

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode temp = sol.mergeTwoLists(list1, list2);

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next; 
        }
    }
}