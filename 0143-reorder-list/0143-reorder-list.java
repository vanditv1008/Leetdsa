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
class Solution {
    public static ListNode midnode(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
    public void reorderList(ListNode head) {
        ListNode mid=midnode(head);
        ListNode rhead=reverse(mid.next);
        mid.next=null;
        ListNode lhead=head;
    
  while (lhead != null && rhead != null) {

    ListNode nextL = lhead.next;
    ListNode nextR = rhead.next;

    lhead.next = rhead;
    rhead.next = nextL;

    lhead = nextL;
    rhead = nextR;
}


    }
}