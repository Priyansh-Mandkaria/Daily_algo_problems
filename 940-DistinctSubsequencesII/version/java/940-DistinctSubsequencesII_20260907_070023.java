// Last updated: 9/7/2026, 7:00:23 AM
1class Solution {
2    public int distinctSubseqII(String s) {
3        int n = s.length();
4        int MOD = (int) 1e9 + 7;
5        int[] countEndWith = new int[26];
6        int sum = 0;
7        for (int i = 0; i < n; i++) {
8            int idx = s.charAt(i) - 'a';
9            int cur = (int) ((1L + sum - countEndWith[idx] + MOD) % MOD);
10            sum = (sum + cur) % MOD;
11            countEndWith[idx] = (countEndWith[idx] + cur) % MOD;
12        }
13        return sum;
14    }
15}