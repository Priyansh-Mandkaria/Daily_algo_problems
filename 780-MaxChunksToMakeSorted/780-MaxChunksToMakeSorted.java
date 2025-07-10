// Last updated: 7/10/2025, 8:57:03 AM
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                maxChunks++;
            }
        }
        return maxChunks;
    }
}