/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// It is guarenteed that node to be deleted is not the tail node of the linked list
// Node passed in the function is the node to be deleted

class Delete_LinkedList_Node_O1 {
    public void deleteNode(ListNode node) {
        //store next node in temp
        ListNode temp = node.next;
        // copy its value, delete next node and assign next node's value to the current node
        int val = temp.val;
        node.next = node.next.next;
        node.val = val;
    }
}