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

class Palindrome_LinkedList_Check {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


    public boolean isPalindrome(ListNode head) {

        // Use slow and fast pointer to find middle of linked list
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at the middle of linkedlist

        // Reverse the second half of linked list and then compare first and second half

        slow = reverseList(slow);
        ListNode temp = head;

        while(slow != null && slow.val == temp.val) {
            slow = slow.next;
            temp = temp.next;
        }

        if (slow == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Creating a palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        Palindrome_LinkedList_Check checker = new Palindrome_LinkedList_Check();
        boolean result = checker.isPalindrome(node1);

        System.out.println("Is Palindrome? " + result); // Expected: true
    }
}