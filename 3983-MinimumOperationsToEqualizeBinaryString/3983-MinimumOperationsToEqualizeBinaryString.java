// Last updated: 6/22/2026, 1:34:59 PM
class Solution {
    private long cd(long a, long b) { return (a + b - 1) / b; }
    public int minOperations(String s, int k) {
        int n = s.length(), z = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') z++;
        if (z == 0) return 0;
        if (k == n) return (z == n) ? 1 : -1;
        if ((k & 1) == 0 && (z & 1) == 1) return -1;
        long lb = cd(z, k), d = n - k;
        long te = Math.max(lb, cd(z, d)), to = Math.max(lb, cd(n - z, d));
        te += (te % 2 == 1) ? 1 : 0;
        to += (to % 2 == 0) ? 1 : 0;
        return (int)((k & 1) == 1 ? ((z & 1) == 0 ? te : to) : Math.min(te, to));
    }
}
