// Last updated: 7/25/2026, 9:23:36 AM
1class Solution {
2    public int addDigits(int n) {
3        return n == 0 ? 0 : 1 + (n-1) % 9;
4    }
5}