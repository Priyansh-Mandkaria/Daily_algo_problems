// Last updated: 7/10/2025, 8:57:22 AM
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] tam = new int[r][c];
        int count = 0;
        if( m * n == r * c){
            for(int i = 0 ; i < m ; i++){
                for( int j = 0 ; j < n; j++ ){
                    tam[count / c][count % c] = mat[i][j];
                    count++;
                }
            }
            return tam;
        }
        return mat;
    }
}