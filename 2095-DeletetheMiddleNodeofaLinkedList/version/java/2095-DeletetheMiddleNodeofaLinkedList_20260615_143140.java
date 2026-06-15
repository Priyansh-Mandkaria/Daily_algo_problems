// Last updated: 6/15/2026, 2:31:40 PM
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
12    public ListNode deleteMiddle(ListNode head) {
13        if(head == null) return head;
14        int size = getleng(head);
15        int middle = 0;
16        if(size % 2 != 0){
17            middle = size/2 + 1;
18        }
19        else{
20            middle = size/2 + 1;
21        }
22        if(middle == 1){
23            head = head.next;
24            return head;
25        }
26        int cnt = 0;
27        ListNode temp = head;
28        ListNode prev = null;
29        while(temp != null){
30            cnt++;
31            if(cnt == middle){
32                prev.next = prev.next.next;
33                break;
34            }
35            prev = temp;
36            temp = temp.next;
37        }
38        return head;
39    }
40    public int getleng(ListNode head){
41       int cnt = 0;
42       ListNode temp = head;
43       while(temp!= null){
44        temp = temp.next;
45        cnt++;
46       } 
47       return cnt;
48    }
49}