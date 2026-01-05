// Last updated: 1/5/2026, 1:29:31 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        long sum=0;
4        int minAbs=Integer.MAX_VALUE, negOdd=0;
5        for (int [] row: matrix){
6            for(int x: row){
7                minAbs=Math.min(minAbs, Math.abs(x));
8                if (x<0){
9                    sum-=x;
10                    negOdd=1-negOdd;
11                }
12                else sum+=x;
13            }
14        }
15        return sum-2*negOdd*minAbs;
16    }
17}