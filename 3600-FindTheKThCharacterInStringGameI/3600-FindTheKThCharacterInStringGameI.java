// Last updated: 7/10/2025, 8:50:34 AM
class Solution {
    public char kthCharacter(int k) {
        return (char)('a' + Integer.bitCount(k - 1));
    }
}