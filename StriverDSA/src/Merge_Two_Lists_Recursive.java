import java.util.*;

/**
 * Recursive approach
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made
 * by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class Merge_Two_Lists_Recursive {

    public ListNode mergeLists(ListNode list1, ListNode list2) {

        // base condition
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        Merge_Two_Lists_Recursive mergeTwoListsRecursive = new Merge_Two_Lists_Recursive();
        ListNode merged = mergeTwoListsRecursive.mergeLists(l1,l2);

        while(merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }

    }
}