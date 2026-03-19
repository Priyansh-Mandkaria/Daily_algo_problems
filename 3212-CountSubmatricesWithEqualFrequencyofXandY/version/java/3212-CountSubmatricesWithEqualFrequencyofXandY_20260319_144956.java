// Last updated: 3/19/2026, 2:49:56 PM
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        
6        int[][] diff = new int[m+1][n+1];
7        boolean[][] has_x = new boolean[m+1][n+1]; 
8        
9        int count = 0;
10        
11        for (int i = 1; i <= m; i++) {  
12            for (int j = 1; j <= n; j++) { 
13                int val = 0;
14                if (grid[i-1][j-1] == 'X') {
15                    val = 1;
16                } else if (grid[i-1][j-1] == 'Y') {
17                    val = -1;
18                }
19                
20                diff[i][j] = diff[i-1][j] + diff[i][j-1] - diff[i-1][j-1] + val;
21                
22                has_x[i][j] = has_x[i-1][j] || has_x[i][j-1] 
23                           || has_x[i-1][j-1] || (grid[i-1][j-1] == 'X');
24                
25                if (has_x[i][j] && diff[i][j] == 0) count++;
26            }
27        }
28        
29        return count;
30    }
31}