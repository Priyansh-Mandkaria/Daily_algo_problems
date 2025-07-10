// Last updated: 7/10/2025, 8:50:50 AM
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int count = 0;
        int[][] arr2 = new int[n][11];
        for (int[] x : pick) {
            int Xi = x[0];
            int Yi = x[1];
            arr2[Xi][Yi] = arr2[Xi][Yi] + 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr2[i][j] > i) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}