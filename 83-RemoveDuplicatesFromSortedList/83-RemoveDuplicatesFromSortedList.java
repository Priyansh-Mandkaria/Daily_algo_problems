// Last updated: 7/10/2025, 8:58:55 AM
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
    public ListNode deleteDuplicates(ListNode head) {
      ListNode ans=head;
      while(head != null && head.next != null){
        if(head.val == head.next.val){
            head.next=head.next.next;  
        }else{
           head=head.next; 
        }
      }
      return ans;
    }
}