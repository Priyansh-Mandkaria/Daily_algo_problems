// Last updated: 6/22/2026, 1:34:41 PM
class Solution {
    public long maxTotalValue(int[] num, int k) {
        int mxv = Integer.MIN_VALUE, mnv = Integer.MAX_VALUE;
        for (int val : num) {
            mxv = Math.max(mxv, val);
            mnv = Math.min(mnv, val);
        }
        return 1L * (mxv - mnv) * k;
    }
}