// Last updated: 7/10/2025, 8:59:46 AM
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break; 
            }
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = kthNode.next;
            reverseGroup(groupStart, groupEnd);
            prevGroupEnd.next = kthNode;
            groupStart.next = groupEnd;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
    private void reverseGroup(ListNode start, ListNode end) {
        ListNode prev = null, curr = start, next = null;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}