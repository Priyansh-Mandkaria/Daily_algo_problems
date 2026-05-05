// Last updated: 5/5/2026, 9:53:34 PM
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0) {
4            return head;
5        }
6        int length = 1;
7        ListNode temp = head;
8        while (temp.next != null) {
9            temp = temp.next;
10            length++;
11        }
12        temp.next = head;
13        k = k % length;
14        k = length - k;
15        while (k-- > 0) {
16            temp = temp.next;
17        }
18        head = temp.next;
19        temp.next = null;
20        return head;
21    }
22}