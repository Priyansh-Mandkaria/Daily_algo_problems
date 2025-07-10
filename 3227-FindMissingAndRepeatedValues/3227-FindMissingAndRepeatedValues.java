// Last updated: 7/10/2025, 8:51:35 AM
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] matrix) {
        long actualSum = 0, actualSquareSum = 0;
        long size = matrix.length;
        long totalElements = size * size;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                actualSum += matrix[i][j];
                actualSquareSum += (long) matrix[i][j] * matrix[i][j];
            }
        }
        long expectedSum = (totalElements * (totalElements + 1)) / 2;
        long expectedSquareSum = (totalElements * (totalElements + 1) * (2 * totalElements + 1)) / 6;
        long sumGap = actualSum - expectedSum;
        long squareSumGap = actualSquareSum - expectedSquareSum;
        int duplicate = (int) (squareSumGap / sumGap + sumGap) / 2;
        int missing = (int) (squareSumGap / sumGap - sumGap) / 2;
        return new int[] { duplicate, missing };
    }
}