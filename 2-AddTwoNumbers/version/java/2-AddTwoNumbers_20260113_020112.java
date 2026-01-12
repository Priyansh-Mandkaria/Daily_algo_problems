// Last updated: 1/13/2026, 2:01:12 AM
1class Solution {
2    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
3        ListNode dummy = new ListNode(0); // creating an dummy list
4        ListNode curr = dummy; // intialising an pointer
5        int carry = 0; // intialising our carry with 0 intiall
6        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it. 
7		// We will add that as well into our list
8        while(l1 != null || l2 != null || carry == 1){
9            int sum = 0; // intialising our sum
10            if(l1 != null){ // adding l1 to our sum & moving l1
11                sum += l1.val;
12                l1 = l1.next;
13            }
14            if(l2 != null){ // adding l2 to our sum & moving l2
15                sum += l2.val;
16                l2 = l2.next;
17            }
18            sum += carry; // if we have carry then add it into our sum
19            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
20            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
21            curr.next = node; // curr will point to that new node if we get
22            curr = curr.next; // update the current every time
23        }
24        return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
25    }
26}