// Last updated: 7/10/2025, 8:59:19 AM
class Solution {
    public void rotate(int[][] old) {
        int n = old.length;
        int m = old[0].length;
        int[][] newe = new int[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                newe[j][n-i-1] = old[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                old[i][j] = newe[i][j];
            }
        }
    }
}