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

class Rotate_LinkedList_by_K {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        int n = 1; // length of LinkedList


        while (first.next != null) {
            first = first.next;
            n++;
        }

        // rotate by k, if k is greater than n, updates

        k = k % n;

        if (k == 0) {
            return head;
        }

        // Find tail for n - k

        ListNode tail = head;

        for(int i=1;i<n-k;i++) {
            tail = tail.next;
        }

        // update head

        ListNode newHead = tail.next;
        tail.next = null;

        // complete the list
        first.next = head;

        return newHead;


    }
}