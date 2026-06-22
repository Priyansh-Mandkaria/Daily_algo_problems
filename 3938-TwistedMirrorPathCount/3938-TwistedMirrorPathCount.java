// Last updated: 6/22/2026, 1:35:32 PM
class Solution {
    private static final int MOD = 1_000_000_007;
    private int m, n;
    private int[][] g;
    private int[][][] mem;

    public int uniquePaths(int[][] grid) {
        m = grid.length; n = grid[0].length; g = grid;
        mem = new int[m][n][2];
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                mem[r][c][0] = (g[r][c] == 0) ? encode(r, c) : (c + 1 >= n ? -1 : mem[r][c + 1][1]);
                mem[r][c][1] = (g[r][c] == 0) ? encode(r, c) : (r + 1 >= m ? -1 : mem[r + 1][c][0]);
            }
        }
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) if (dp[r][c] > 0) {
                int[] dR = dest(r, c, 1);
                if (dR[0] != -1) dp[dR[0]][dR[1]] = (dp[dR[0]][dR[1]] + dp[r][c]) % MOD;
                int[] dD = dest(r, c, 0);
                if (dD[0] != -1) dp[dD[0]][dD[1]] = (dp[dD[0]][dD[1]] + dp[r][c]) % MOD;
            }
        }
        return (int) dp[m - 1][n - 1];
    }

    private int[] dest(int r, int c, int dir) {
        if (dir == 1) {
            int nc = c + 1;
            if (nc >= n) return new int[]{-1, -1};
            if (g[r][nc] == 0) return new int[]{r, nc};
            int nr = r + 1; if (nr >= m) return new int[]{-1, -1};
            return decode(mem[nr][nc][0]);
        } else {
            int nr = r + 1;
            if (nr >= m) return new int[]{-1, -1};
            if (g[nr][c] == 0) return new int[]{nr, c};
            int nc = c + 1; if (nc >= n) return new int[]{-1, -1};
            return decode(mem[nr][nc][1]);
        }
    }

    private int encode(int r, int c) { return (r << 16) | c; }
    private int[] decode(int val) { return new int[]{val >> 16, val & 0xFFFF}; }
}
