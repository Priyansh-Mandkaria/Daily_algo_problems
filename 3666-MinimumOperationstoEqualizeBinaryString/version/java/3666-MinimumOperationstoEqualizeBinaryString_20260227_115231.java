// Last updated: 2/27/2026, 11:52:31 AM
1class Solution {
2    private long cd(long a, long b) { return (a + b - 1) / b; }
3    public int minOperations(String s, int k) {
4        int n = s.length(), z = 0;
5        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') z++;
6        if (z == 0) return 0;
7        if (k == n) return (z == n) ? 1 : -1;
8        if ((k & 1) == 0 && (z & 1) == 1) return -1;
9        long lb = cd(z, k), d = n - k;
10        long te = Math.max(lb, cd(z, d)), to = Math.max(lb, cd(n - z, d));
11        te += (te % 2 == 1) ? 1 : 0;
12        to += (to % 2 == 0) ? 1 : 0;
13        return (int)((k & 1) == 1 ? ((z & 1) == 0 ? te : to) : Math.min(te, to));
14    }
15}
16