// Last updated: 3/22/2026, 12:08:12 PM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        if(compare(mat, target))return true;
4        int count = 3;
5        while(count > 0){
6            mat = rotate(mat);
7            if(compare(mat, target))return true;
8            count--;
9        }
10        return false;
11    }
12
13    private boolean compare(int[][] mat, int[][] target){
14        int n = mat.length;
15        for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(mat[i][j]!=target[i][j])return false;
16        return true;
17    }
18
19    private int[][]rotate(int[][]mat){
20        int n = mat.length;
21        int[][]res = new int[n][n];
22
23        for(int i=0;i<n;i++){
24            for(int j=0;j<n;j++){
25                res[n-1-j][i] = mat[i][j];
26            }
27        }
28
29        return res;
30    }
31}