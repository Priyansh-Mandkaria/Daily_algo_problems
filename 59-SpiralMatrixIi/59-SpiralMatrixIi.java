// Last updated: 7/10/2025, 8:59:09 AM
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int left = 0 ; int right = n-1;
        int top = 0; int bottom = n-1;
        if (matrix.length == 0) {
            return matrix;
        }
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = count;
                    count++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = count;
                    count++;
                }
                left++;
            }
        }       
        return matrix;
    }
}