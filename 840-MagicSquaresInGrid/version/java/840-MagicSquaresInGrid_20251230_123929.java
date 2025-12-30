// Last updated: 12/30/2025, 12:39:29 PM
1class Solution {
2    public int numMagicSquaresInside(int[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5        int count = 0;  
6        for (int i = 0; i < rows - 2; i++) {
7            for (int j = 0; j < cols - 2; j++) {
8                if (isMagic(grid, i, j)) {
9                    count++;
10                }
11            }
12        }  
13        return count;
14    }
15    private boolean isMagic(int[][] grid, int r, int c) {
16        boolean[] seen = new boolean[10];
17        for (int i = 0; i < 3; i++) {
18            for (int j = 0; j < 3; j++) {
19                int num = grid[r + i][c + j];
20                if (num < 1 || num > 9 || seen[num]) return false;
21                seen[num] = true;
22            }
23        }
24        int sum1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
25        int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
26        int sum3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
27        int sum4 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
28        int sum5 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1];
29        int sum6 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2];
30        int sum7 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
31        int sum8 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]; 
32        return sum1 == 15 && sum2 == 15 && sum3 == 15 &&
33               sum4 == 15 && sum5 == 15 && sum6 == 15 &&
34               sum7 == 15 && sum8 == 15;
35    }
36}