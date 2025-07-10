// Last updated: 7/10/2025, 8:54:58 AM
class Solution {
    public int diagonalSum(int[][] mat) {
        int[] temp1 = new int[mat.length];
        int[] temp2 = new int[mat.length];
        int sum = 0;
        // Primary diagonal
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    temp1[i] = mat[i][j];
                }
            }
        }
        // Secondary diagonal
        int end = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            temp2[i] = mat[i][end];
            end--;
        }
        // Adding both elements
        for (int i = 0; i < temp1.length; i++) {
            // Add primary diagonal element
            if(temp1.length % 2 == 0){
                sum += temp1[i] + temp2[i]; }
            else {
                if(i == (temp1.length-1)/2 ){
                    sum += temp2[i];
                }
                else{
                sum += temp1[i] + temp2[i];
                }
            }
        }
        return sum;
    }
}