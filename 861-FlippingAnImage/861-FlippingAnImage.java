// Last updated: 7/10/2025, 8:56:52 AM
class Solution {
    public void Swap(int[] row, int start, int end) {
        int temp = row[start];
        row[start] = row[end];
        row[end] = temp;
    }
    
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image[i].length - 1; // Adjust end index to the last valid index
            while (start < end) {
                Swap(image[i], start, end);
                start++;
                end--;
            }
            // Invert the row
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] ^ 1;
            }
        }
        return image;
    }
}
