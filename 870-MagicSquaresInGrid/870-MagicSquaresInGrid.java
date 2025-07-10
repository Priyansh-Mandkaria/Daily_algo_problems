// Last updated: 7/10/2025, 8:56:48 AM
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;  
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }  
        return count;
    }
    private boolean isMagic(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        int sum1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
        int sum3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
        int sum4 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
        int sum5 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1];
        int sum6 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2];
        int sum7 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int sum8 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]; 
        return sum1 == 15 && sum2 == 15 && sum3 == 15 &&
               sum4 == 15 && sum5 == 15 && sum6 == 15 &&
               sum7 == 15 && sum8 == 15;
    }
}