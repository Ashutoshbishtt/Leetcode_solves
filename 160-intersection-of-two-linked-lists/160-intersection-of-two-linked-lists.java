/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        
        while(headA!=null){
            map.put(headA,1);
            headA=headA.next;
        }
        
        while(headB!=null){
            if(map.containsKey(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
