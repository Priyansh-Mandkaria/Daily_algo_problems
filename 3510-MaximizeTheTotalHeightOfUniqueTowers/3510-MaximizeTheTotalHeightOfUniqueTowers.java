// Last updated: 7/10/2025, 8:50:54 AM
class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long ts = 0;
        int ch = maximumHeight[maximumHeight.length - 1];
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            if (ch > maximumHeight[i]) {
                ch = maximumHeight[i];
            }
            if (ch <= 0) {
                return -1;
            }
            ts = ts + ch;
            ch--;
        }
        return ts;
    }
}