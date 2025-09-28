// Last updated: 9/28/2025, 7:54:47 AM
class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int n = arr.length;
          int m = arr[0].length;
          int low = 0;
          int high = m - 1;
          while (low <= high) {
              int mid = (low + high) / 2;
              int row = maxElement(arr, mid);
              int left = mid - 1 >= 0 ? arr[row][mid - 1] : Integer.MIN_VALUE;
              int right = mid + 1 < m ? arr[row][mid + 1] : Integer.MIN_VALUE;
              if (arr[row][mid] > left && arr[row][mid] > right) {
                  return new int[]{row, mid};
              } else if (left > arr[row][mid]) {
                  high = mid - 1;
              } else {
                  low = mid + 1;
              }
          }
          return new int[]{-1, -1};
    }
    public int maxElement(int[][] arr, int col) {
          int n = arr.length;
          int max = Integer.MIN_VALUE;
          int index = -1;
          for (int i = 0; i < n; i++) {
              if (arr[i][col] > max) {
                  max = arr[i][col];
                  index = i;
              }
          }
          return index;
      }
}