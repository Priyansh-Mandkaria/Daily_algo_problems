// Last updated: 8/23/2026, 9:39:43 AM
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length(), half = n / 2;
4        int sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;
5        for (int i = 0; i < half; i++) {
6            if (num.charAt(i) == '?') cnt1++;
7            else sum1 += num.charAt(i) - '0';
8        }
9        for (int i = half; i < n; i++) {
10            if (num.charAt(i) == '?') cnt2++;
11            else sum2 += num.charAt(i) - '0';
12        }
13        int totalQ = cnt1 + cnt2;
14        if (totalQ % 2 == 1) return true;
15        return 2 * (sum1 - sum2) != 9 * (cnt2 - cnt1);
16    }
17}