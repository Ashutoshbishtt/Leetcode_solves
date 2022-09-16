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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2,int carry) {
        if(l1==null && l2==null){
            if(carry!=0){
                return new ListNode(carry);
            }
            return null;
        }
        
        int sum=0;
        
        if(l1!=null){
            sum+=l1.val;
        }
        if(l2!=null){
            sum+=l2.val;
        }
        
        sum+=carry;
        
        int ncarry=sum/10;
        
        sum=sum%10;
        ListNode child = new ListNode(sum);
        
        if(l1!=null && l2!=null){
           ListNode mSmall=addTwoNumbers(l1.next,l2.next,ncarry);
            child.next=mSmall;
        return child;
        }
        else if(l1==null && l2!=null){
           ListNode mSmall=addTwoNumbers(null,l2.next,ncarry);
            child.next=mSmall;
        return child;
        }
        else if(l1!=null && l2==null){
            ListNode mSmall=addTwoNumbers(l1.next,null,ncarry);
            child.next=mSmall;
            return child;
        }
        return null;
    }
}