// Last updated: 7/10/2025, 8:50:47 AM
class Solution {
    public int minFlips(int[][] grid) {  
        int flip1_row_wala = 0;
        for (int i = 0; i < grid.length; i++) {
            int Count1 = 0;
            for (int j = 0; j < grid[0].length / 2; j++) {
                if (grid[i][j] != grid[i][grid[0].length - 1 - j]) {
                    Count1 = Count1 + 1;
                }
            }
            flip1_row_wala = flip1_row_wala + Count1;
        } 
        int flip2_col_wala = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int Count2 = 0;
            for (int i = 0; i < grid.length / 2; i++) {
                if (grid[i][j] != grid[grid.length - 1 - i][j]) {
                    Count2 = Count2 + 1;
                }
            }
            flip2_col_wala = flip2_col_wala + Count2;
        }     
        int min_flip = Math.min(flip1_row_wala,flip2_col_wala);
        return min_flip;
    }
}