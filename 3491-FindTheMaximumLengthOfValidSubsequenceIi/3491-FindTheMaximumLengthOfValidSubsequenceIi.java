// Last updated: 7/22/2025, 12:05:52 PM
class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int max = 0;
        for (int n : nums) {
            int r = n % k;
            for (int p = 0; p < k; p++)
                max = Math.max(max, dp[p][r] = dp[r][p] + 1);
        }
        return max;
    }
}