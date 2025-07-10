// Last updated: 7/10/2025, 8:52:35 AM
class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1;
        return 2L * n * (n-1) + 1;
    }
}