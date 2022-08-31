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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0 || head.next==null)return head;
        
        ListNode temp = head;
        int count = 1;
        
        while(temp.next!=null){
            count++;
            temp=temp.next;
            
        }
        temp.next=head;
        k = k%count;
        k=count-k;
        
        
        
        while(k-->0){
            temp=temp.next;
        }
        
        head=temp.next;
        temp.next=null;
        return head;
    }
}