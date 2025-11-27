// Last updated: 11/27/2025, 2:45:04 PM
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        long prefSum = 0;
4        long subMax = Long.MIN_VALUE;
5        long[] minSoFar = new long[k];
6        Arrays.fill(minSoFar, Long.MAX_VALUE / 2);
7        minSoFar[(k - 1) % k] = 0;
8        for (int i = 0; i < nums.length; i++) {
9            prefSum += nums[i];
10            subMax = Math.max(subMax, prefSum - minSoFar[i % k]);
11            minSoFar[i % k] = Math.min(minSoFar[i % k], prefSum);
12        }
13        return subMax;
14    }
15}
16