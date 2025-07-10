// Last updated: 7/10/2025, 8:50:33 AM
class Solution {
    public char kthCharacter(long k, int[] A) {
        int res = 0, n = A.length;
        k -= 1;
        for (int i = 0; i < n && i < 60; ++i)
            if ((k >> i) % 2 > 0)
                res += A[i];
        return (char)('a' + res % 26);
    }
}