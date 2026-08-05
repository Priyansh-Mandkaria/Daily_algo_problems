// Last updated: 8/5/2026, 11:37:38 AM
1class Solution {
2    public int minBitFlips(int start, int goal) {
3        return Integer.bitCount(start ^ goal);
4    }
5}
6