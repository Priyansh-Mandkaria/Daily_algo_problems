// Last updated: 6/22/2026, 1:37:27 PM
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefSum = 0;
        long subMax = Long.MIN_VALUE;
        long[] minSoFar = new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE / 2);
        minSoFar[(k - 1) % k] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            subMax = Math.max(subMax, prefSum - minSoFar[i % k]);
            minSoFar[i % k] = Math.min(minSoFar[i % k], prefSum);
        }
        return subMax;
    }
}
