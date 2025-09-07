// Last updated: 9/7/2025, 10:54:52 AM
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        res[0] = n * (1 - n) / 2;
        for (int i = 1; i < n; ++i)
            res[i] = i;
        return res;
    }
}