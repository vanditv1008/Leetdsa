class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        // Traverse the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                // Move forward only if we didn't delete the next node 
                // (handles consecutive matching values)
                current = current.next;
            }
        }
        
        // Return the new head, skipping the dummy node
        return dummy.next;
    }
}