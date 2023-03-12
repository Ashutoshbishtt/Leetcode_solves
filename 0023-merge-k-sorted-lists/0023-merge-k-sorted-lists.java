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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeaps = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        for (ListNode list : lists) {
            while (list != null) {
                minHeaps.add(list);
                list = list.next;
            }
        }

        while (!minHeaps.isEmpty()) {
            dummy.next = minHeaps.poll();
            dummy = dummy.next;
            dummy.next = null;
        }
        return head.next;
    }
}
