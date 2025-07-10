// Last updated: 7/10/2025, 8:55:50 AM
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        
        // Process each index pair [ri, ci]
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            
            // Increment row
            for (int j = 0; j < n; j++) {
                mat[row][j]++;
            }
            
            // Increment column
            for (int i = 0; i < m; i++) {
                mat[i][col]++;
            }
        }
        
        // Count odd values
        int oddCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 != 0) {
                    oddCount++;
                }
            }
        }
        
        return oddCount;
    }
}