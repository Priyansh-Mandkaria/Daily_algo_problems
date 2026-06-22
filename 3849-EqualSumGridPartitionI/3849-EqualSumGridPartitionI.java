// Last updated: 6/22/2026, 1:36:19 PM
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long[] row_sum = new long[m], col_sum = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                row_sum[i] += val; col_sum[j] += val;
            }
        }

        long[] row_prefix = new long[m + 1];
        for (int i = 0; i < m; i++) {
            row_prefix[i + 1] = row_prefix[i] + row_sum[i];
        }

        long[] col_prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            col_prefix[i + 1] = col_prefix[i] + col_sum[i];
        }

        long total_sum = row_prefix[m];

        if (total_sum % 2 != 0) {
            return false;
        }

        long target = total_sum / 2;

        for (int i = 1; i < m; i++) {
            if (row_prefix[i] == target) {
                return true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (col_prefix[i] == target) {
                return true;
            }
        }
        
        return false;
    }
}