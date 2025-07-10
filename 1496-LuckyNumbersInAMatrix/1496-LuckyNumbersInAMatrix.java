// Last updated: 7/10/2025, 8:55:33 AM
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;   
        List<Integer> luckyNumbers = new ArrayList<>();
        // Find the minimum element in each row
        int[] rowMins = new int[m];
        for (int i = 0; i < m; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            rowMins[i] = min;
        }
        // Check if the minimum element in the row is the maximum element in its column
        for (int i = 0; i < m; i++) {
            int min = rowMins[i];
            boolean isLucky = true;
            for (int j = 0; j < m; j++) {
                if (matrix[j][findIndex(matrix[i], min)] > min) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                luckyNumbers.add(min);
            }
        }
        return luckyNumbers;
    }
    private static int findIndex(int[] row, int value) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == value) {
                return i;
            }
        }
        return -1;
    }
}