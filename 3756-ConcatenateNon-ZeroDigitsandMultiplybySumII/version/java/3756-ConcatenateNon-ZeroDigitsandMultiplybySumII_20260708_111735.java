// Last updated: 7/8/2026, 11:17:35 AM
1class Solution {
2    public int[] sumAndMultiply(String s, int[][] queries) {
3        final int MOD = 1_000_000_007;
4        int n = s.length();
5        long[] pow10 = new long[n + 1];
6        pow10[0] = 1;
7        for (int i = 1; i <= n; i++) {
8            pow10[i] = (pow10[i - 1] * 10) % MOD;
9        }
10        int[] idx = new int[n + 1];
11        long[] val = new long[n + 1];
12        long[] total = new long[n + 1];
13        int cnt = 0;
14        for (int i = 0; i < n; i++) {
15            int digit = s.charAt(i) - '0';
16            if (digit != 0) {
17                cnt++;
18                val[cnt] = (val[cnt - 1] * 10 + digit) % MOD;
19                total[cnt] = total[cnt - 1] + digit;
20            }
21            idx[i + 1] = cnt;
22        }
23        int[] ans = new int[queries.length];
24        for (int i = 0; i < queries.length; i++) {
25            int l = queries[i][0];
26            int r = queries[i][1];
27            int left = idx[l];
28            int right = idx[r + 1];
29            if (left == right) {
30                ans[i] = 0;
31                continue;
32            }
33            int len = right - left;
34            long number = (val[right] - (val[left] * pow10[len]) % MOD) % MOD;
35            if (number < 0)
36                number += MOD;
37            long sum = total[right] - total[left];
38            ans[i] = (int) ((number * sum) % MOD);
39        }
40        return ans;
41    }
42}