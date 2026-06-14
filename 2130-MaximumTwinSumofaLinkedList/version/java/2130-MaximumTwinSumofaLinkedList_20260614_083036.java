// Last updated: 6/14/2026, 8:30:36 AM
1class Solution {
2    public int pairSum(ListNode head) {
3        ListNode slow = head, fast = head, prev = null;
4        while (fast != null && fast.next != null) {
5            fast = fast.next.next;
6            ListNode temp = slow.next;
7            slow.next = prev;
8            prev = slow;
9            slow = temp;
10        }
11        int res = 0;
12        while (slow != null) {
13            res = Math.max(res, prev.val + slow.val);
14            prev = prev.next;
15            slow = slow.next;
16        }
17        return res;
18    }
19}