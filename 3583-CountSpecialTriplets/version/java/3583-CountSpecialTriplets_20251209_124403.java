// Last updated: 12/9/2025, 12:44:03 PM
1class Solution {
2    public int specialTriplets(int[] nums) {
3        int n = 100001, mod = 1000000007;
4        long ans = 0;
5        int[] hash = new int[n], prev = new int[n];
6        for(int i = 0; i < nums.length; i++) hash[nums[i]]++;
7        for(int i = 1; i < nums.length - 1; i++) {
8            prev[nums[i - 1]]++;
9            int j = nums[i], k = 2*j;
10            if(k < n) {
11                ans += (long)prev[k] * (hash[k] - prev[k] - (j == 0 ? 1 : 0));
12            }
13        }
14        return (int)(ans % mod);
15    }
16}