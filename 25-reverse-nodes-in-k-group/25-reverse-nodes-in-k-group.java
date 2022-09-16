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
    private int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null)return head;
        
        int length = getLength(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur;
        ListNode nex;
        
        while(length>=k){
            cur=pre.next;
            nex=cur.next;
            for(int i = 1 ; i < k ; i++){
                cur.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=cur.next;
            }
            pre=cur;
            length-=k;
        }
        return dummy.next;
    }
}