// Last updated: 6/15/2026, 2:33:11 PM
1class Solution {
2    public ListNode deleteMiddle(ListNode head) {
3        if(head == null || head.next == null) return null;
4        ListNode slow = head;
5        ListNode fast = head;
6        ListNode prev = null;
7        while(fast != null && fast.next != null){
8            prev = slow;
9            slow = slow.next;
10            fast = fast.next.next;
11        }
12        prev.next = slow.next;
13        return head;
14    }
15}