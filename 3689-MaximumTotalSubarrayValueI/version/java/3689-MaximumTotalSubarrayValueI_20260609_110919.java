// Last updated: 6/9/2026, 11:09:19 AM
1class Solution {
2    public long maxTotalValue(int[] num, int k) {
3        int mxv = Integer.MIN_VALUE, mnv = Integer.MAX_VALUE;
4        for (int val : num) {
5            mxv = Math.max(mxv, val);
6            mnv = Math.min(mnv, val);
7        }
8        return 1L * (mxv - mnv) * k;
9    }
10}