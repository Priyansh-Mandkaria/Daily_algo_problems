// Last updated: 8/31/2025, 12:04:07 PM
class Solution {
        public long maxProduct(int[] A) {
        int max_val = 0;
        for (int val : A) {
            if (val > max_val) {
                max_val = val;
            }
        }
        int k = (int) (Math.log(max_val) / Math.log(2)) + 1;
        int mask = 1 << k;
        int[] dp = new int[mask];
        for (int a : A) {
            dp[a] = a;
        }

        for (int j = 0; j < k; ++j) {
            for (int i = 0; i < mask; ++i) {
                if ((i & (1 << j)) != 0) {
                    dp[i] = Math.max(dp[i], dp[i ^ (1 << j)]);
                }
            }
        }

        long res = 0;
        for (int a : A) {
            int complement = (mask - 1) ^ a;
            res = Math.max(res, (long) a * dp[complement]);
        }
        return res;
    }
}