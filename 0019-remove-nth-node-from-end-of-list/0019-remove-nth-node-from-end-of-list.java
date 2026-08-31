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
    public static int size(ListNode head){
        ListNode temp=head;
        int sz=0;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        return sz;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=size(head);
        if (n == sz) {
            return head.next;
        }

       ListNode temp=head;
       int steps=sz-n;
       while(steps>1 ){
        temp=temp.next;
        steps--;
       }
       temp.next=temp.next.next;
        
        return head;
        
    }
}