// Last updated: 2/16/2026, 11:46:02 AM
1class Solution {
2    public int reverseBits(int n) { return rev(n, 32); }
3    private int rev(int v, int len) {
4        if (len == 1) return v & 1;
5        int half = len >> 1;
6        int mask = (1 << half) - 1;
7        int lo = v & mask;
8        int hi = v >>> half;
9        return (rev(lo, half) << half) | rev(hi, half);
10    }
11}
12