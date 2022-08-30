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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        
        ListNode head =null,curr=null;
        
        if(list1.val<=list2.val){
            head=list1;
            curr=head;
            list1=list1.next;
            curr.next=null;
        }else{
            head=list2;
            curr=head;
            list2=list2.next;
            curr.next=null;
        }
        
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                curr=curr.next;
                list1=list1.next;
                curr.next=null;
            }else{
                curr.next=list2;
                curr=curr.next;
                list2=list2.next;
                curr.next=null;
            }
        }
        if(list1==null)curr.next=list2;
        else curr.next=list1;
        
        return head;
    }
}