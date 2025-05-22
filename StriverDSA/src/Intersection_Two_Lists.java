import java.util.*;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 */


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Intersection_Two_Lists {

    // without extra space
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }


    // With O(N) extra space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> s = new HashSet<>();
        ListNode l1 = headA;

        while(l1 != null) {
            s.add(l1);
            l1 = l1.next;
        }

        ListNode l2 = headB;

        while (l2 != null) {
            if (s.contains(l2)) {
                return l2;
            } else {
                l2 = l2.next;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        // Shared part
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(10);

        // List A: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = intersection;

        // List B: 99 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = intersection;

        Intersection_Two_Lists solution = new Intersection_Two_Lists();
        ListNode result = solution.getIntersectionNode(headA, headB);
        ListNode result2 = solution.getIntersectionNode2(headA, headB);

        System.out.println("Intersection at node with value: " + (result != null ? result.val : "null"));
        System.out.println("Intersection at node with value: " + (result2 != null ? result2.val : "null"));
    }
}
