// Last updated: 7/10/2025, 8:48:59 AM
class Solution {
    public String concatHex36(int n) {
        return Integer.toHexString(n * n).toUpperCase() + Integer.toString(n * n * n,36).toUpperCase();
    }
}