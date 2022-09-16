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
   private static ListNode re;
    public boolean isPalindrome(ListNode head) {
        re=head;
        return isHelper(head);
    }
    private static boolean isHelper(ListNode head){
        if(head==null)return true;
        
        boolean past = isHelper(head.next);
        boolean ans=false;
        if(head.val==re.val){
            ans=true;
        }
        re=re.next;
        
        return ans && past;
    }
}