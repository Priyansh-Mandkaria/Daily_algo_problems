// Last updated: 7/14/2025, 8:15:07 AM
class Solution {
    public int getDecimalValue(ListNode head) {
        int count = 1; 
        int num = 0;   
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count *= 2; 
        }
        count /= 2; 
        cur = head; 
        while (cur != null) {
            num += cur.val * count; 
            count /= 2;             
            cur = cur.next;
        }
        return num; 
    }
}