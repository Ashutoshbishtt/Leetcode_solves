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
    int size;
    ListNode head;
    Random rn;

    public Solution(ListNode head) {
        ListNode temp = head;
        size = 1;
        rn = new Random();
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp.next = head;
        this.head = head;
    }

    public int getRandom() {
        int toMove = rn.nextInt(size);
        while (toMove > 0) {
            toMove--;
            head = head.next;
        }
        return head.val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
