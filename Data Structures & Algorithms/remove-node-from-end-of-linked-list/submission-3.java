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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head;
        int no=0;
        while(cur!=null)
        {
            no++;
            cur=cur.next;
        }
        cur=head;
        int target=no-n;
        if(target==0) return head.next;
        for(int i=1;i<target;i++)
        {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;

    }
}
