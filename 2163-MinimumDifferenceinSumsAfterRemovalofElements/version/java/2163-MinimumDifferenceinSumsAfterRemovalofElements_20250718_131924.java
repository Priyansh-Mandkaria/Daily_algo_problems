// Last updated: 7/18/2025, 1:19:24 PM
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long[] maxSum = new long[n + 2];
        long sum = 0;
        for (int i = 2 * n; i < 3 * n; i++) {
            minHeap.offer(nums[i]);
            sum += nums[i];
        }
        maxSum[n + 1] = sum;
        for (int i = 2 * n - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sum += nums[i];
            int removed = minHeap.poll();
            sum -= removed;
            maxSum[i - n + 1] = sum;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] minSum = new long[n + 2];
        sum = 0;
        for (int i = 0; i < n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
        }
        minSum[0] = sum;
        for (int i = n; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
            int removed = maxHeap.poll();
            sum -= removed;
            minSum[i - n + 1] = sum;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, minSum[i] - maxSum[i + 1]);
        }
        return ans;
    }
}