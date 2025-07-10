// Last updated: 7/10/2025, 8:52:00 AM
class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        int start = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        for (int end = 0; end < n; end++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[end]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(end);
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[end]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(end);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == start) maxDeque.pollFirst();
                if (minDeque.peekFirst() == start) minDeque.pollFirst();
                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }
}