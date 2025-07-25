// Last updated: 7/10/2025, 8:53:07 AM
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long)n * (n - 1) / 2;
        Map<Integer, Long> diffCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            totalPairs -= diffCount.getOrDefault(diff, 0L);
            diffCount.put(diff, diffCount.getOrDefault(diff, 0L) + 1);
        }
        return totalPairs;
    }
}