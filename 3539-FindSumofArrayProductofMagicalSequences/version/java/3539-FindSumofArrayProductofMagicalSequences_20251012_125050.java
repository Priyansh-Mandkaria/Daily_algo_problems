// Last updated: 10/12/2025, 12:50:50 PM
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 31;
    private static final long[] F = new long[MX];
    private static final long[] arr1 = new long[MX];

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) 
            F[i] = F[i - 1] * i % MOD;

        arr1[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) 
            arr1[i - 1] = arr1[i] * i % MOD;
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) 
                res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= m; j++) 
                arr[i][j] = (int) ((long) arr[i][j - 1] * nums[i] % MOD);
        }

        int[][][][] dp = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : dp) 
            for (int[][] b : a) 
                for (int[] c : b) 
                    Arrays.fill(c, -1);
        return (int) (dfs(0, m, 0, k, arr, dp) * F[m] % MOD);
    }

    private long dfs(int i, int leftM, int x, int leftK, int[][] arr, int[][][][] dp) {
        int c1 = Integer.bitCount(x);
        if (c1 + leftM < leftK) 
            return 0;
        if (i == arr.length) 
            return leftM == 0 && c1 == leftK ? 1 : 0;
        if (dp[i][leftM][x][leftK] != -1) 
            return dp[i][leftM][x][leftK];
        long res = 0;
        for (int j = 0; j <= leftM; j++) {
            int bit = (x + j) & 1;
            if (bit <= leftK) {
                long r = dfs(i + 1, leftM - j, (x + j) >> 1, leftK - bit, arr, dp);
                res = (res + r * arr[i][j] % MOD * arr1[j]) % MOD;
            }
        }
        return dp[i][leftM][x][leftK] = (int) res;
    }
}