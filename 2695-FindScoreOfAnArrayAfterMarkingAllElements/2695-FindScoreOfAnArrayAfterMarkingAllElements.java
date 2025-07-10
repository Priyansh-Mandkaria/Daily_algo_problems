// Last updated: 7/10/2025, 8:52:25 AM
class Solution {
    public long findScore(int[] nums) {
       int n = nums.length;
        boolean[] marked = new boolean[n]; 
        long score = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); 
            return Integer.compare(a[1], b[1]); 
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];
            if (marked[index]) continue;
            score += value;
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }
        return score; 
    }
}