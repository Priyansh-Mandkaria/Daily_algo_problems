// Last updated: 8/4/2026, 4:35:55 PM
1class Solution {
2    public int[] findDegrees(int[][] matrix) {
3        int[] arr = new int[matrix.length];
4        for(int i = 0; i < matrix.length; i++){
5            for(int j = 0; j < matrix[i].length; j++){
6                arr[i] += matrix[i][j];
7            }
8        }
9        return arr;
10    }
11}