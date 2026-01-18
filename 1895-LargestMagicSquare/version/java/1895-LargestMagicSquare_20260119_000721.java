// Last updated: 1/19/2026, 12:07:21 AM
1class Solution {
2    public int largestMagicSquare(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int side = Math.min(m,n);
5
6        while(side > 0){
7            for(int i=0;i<m;i++){
8                for(int j=0;j<n;j++){
9                    if(i+side<=m && j+side<=n){
10                        if(isValid(grid,m,n,i,j,side))return side;
11                    }
12                }
13            }
14            side--;
15        }
16
17        return 0;
18    }
19
20    private boolean isValid(int[][] grid, int m, int n, int i, int j, int side) {
21        int sum = 0;
22
23        // rows
24        for (int x = i; x < i + side; x++) {
25            int summ = 0;
26            for (int y = j; y < j + side; y++) {
27                summ += grid[x][y];
28            }
29            if (x == i) sum = summ;
30            else if (sum != summ) return false;
31        }
32
33        // columns
34        for (int x = j; x < j + side; x++) {
35            int summ = 0;
36            for (int y = i; y < i + side; y++) {
37                summ += grid[y][x];
38            }
39            if (sum != summ) return false;
40        }
41
42        // main diagonal
43        int summ = 0;
44        for (int k = 0; k < side; k++) {
45            summ += grid[i + k][j + k];
46        }
47        if (sum != summ) return false;
48
49        // anti-diagonal
50        summ = 0;
51        for (int k = 0; k < side; k++) {
52            summ += grid[i + k][j + side - 1 - k];
53        }
54        if (sum != summ) return false;
55
56        return true;
57    }
58
59}