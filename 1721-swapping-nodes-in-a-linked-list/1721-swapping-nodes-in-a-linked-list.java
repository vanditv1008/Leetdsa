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
    public static int sizes(ListNode head){
        int sz=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        return sz;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int size=sizes(head)-k+1;
        ListNode prevX=null;
        ListNode prevY=null;
        ListNode currX=head;
        ListNode currY=head;
        int i=1;
        while(i<k){
            prevX=currX;
            currX=currX.next;
            i++;
        }
        i=1;
        while(i<size){
            prevY=currY;
            currY=currY.next;
            i++;
        }
        if(prevX!=null){
            prevX.next=currY;
        }else{
            head=currY;
        }
        if(prevY!=null){
            prevY.next=currX;
        }else{
            head=currX;
        }
        ListNode temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
        return head;

    }
}