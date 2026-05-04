// Last updated: 5/4/2026, 3:04:44 PM
1class Solution {
2    public void rotate(int[][] old) {
3        int n = old.length;
4        int m = old[0].length;
5        int[][] newe = new int[n][m]; 
6        for(int i = 0 ; i < n ; i++){
7            for(int j = 0 ; j < m ; j++){
8                newe[j][n-i-1] = old[i][j];
9            }
10        }
11        for(int i = 0 ; i < n ; i++){
12            for(int j = 0 ; j < m ; j++){
13                old[i][j] = newe[i][j];
14            }
15        }
16    }
17}