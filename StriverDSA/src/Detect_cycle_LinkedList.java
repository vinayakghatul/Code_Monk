class Detect_cycle_LinkedList {

    /**
     * Use slow and fast pointer
     * start both at head, if both meet somewhere then there exists cycle in LL
     * Add relevant conditions and move pointers accordingly
     * @param head
     * @return
     */

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

}