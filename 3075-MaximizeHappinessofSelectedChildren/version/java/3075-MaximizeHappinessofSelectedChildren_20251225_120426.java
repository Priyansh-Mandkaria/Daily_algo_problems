// Last updated: 12/25/2025, 12:04:26 PM
1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        Arrays.sort(happiness);
4        long ans = 0;
5        int n = happiness.length - 1;
6        for(int i = 0; i < k; i++) {
7            int val = happiness[n - i] - i;
8            if(val > 0) ans += val;
9            else break;
10        }
11        return ans;
12    }
13}