/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


class Remove_nth_Node_LinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // go till n node from beginning

        // once reached at nth node, start second head from start and move both till first pointer reaches end

        // now first pointer is at the nth node from end and second at at the end of List

        //make second.next = second.next.next

        ListNode first = head;

        for (int i=0;i<n;i++) {
            first = first.next;
        }

        if (first == null) {
            return head.next;
        }
        ListNode second = head;

        while(first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;

    }
}