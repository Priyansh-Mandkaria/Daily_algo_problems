// Last updated: 7/10/2025, 8:53:02 AM
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0;
        int whiteCount = 0;
        int minOperations = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }
            if (right - left + 1 == k) {
                minOperations = Math.min(minOperations, whiteCount);
                if (blocks.charAt(left) == 'W') {
                    whiteCount--;
                }
                left++;
            }
        }
        return minOperations;
    }
}