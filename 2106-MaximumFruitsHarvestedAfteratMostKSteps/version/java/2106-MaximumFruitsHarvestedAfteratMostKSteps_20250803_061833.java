// Last updated: 8/3/2025, 6:18:33 AM
// vald
class Solution {
    public int maxTotalFruits(int[][] f, int pos, int k) {
    int l = 0, sum = 0, max_sum = 0;
    while (l < f.length && f[l][0] < pos - k) l++;
    for (int r = l; r < f.length && f[r][0] <= pos + k; r++) {
        sum += f[r][1];
        while(Math.min(pos - 2 * f[l][0] + f[r][0], 2 * f[r][0] - f[l][0] - pos) > k)sum -= f[l++][1];
        max_sum = Math.max(max_sum, sum);
    }
    return max_sum;
    }
}