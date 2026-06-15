// Last updated: 6/15/2026, 10:09:55 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        if (head.next == null) return null;
14        ListNode ptr = head;
15        ListNode temp = head;
16        int i = 1;
17        while (i <= n) {
18            ptr = ptr.next; 
19            i++;
20        }
21        if (ptr == null) return head.next;
22        while (ptr.next != null) {
23            ptr = ptr.next;
24            temp = temp.next;
25        } 
26        if (temp.next != null) {
27            temp.next = temp.next.next;
28        }
29        return head;
30    }
31}