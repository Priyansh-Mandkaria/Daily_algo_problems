// Last updated: 7/10/2025, 8:57:32 AM
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}