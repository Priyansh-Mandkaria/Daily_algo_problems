// Last updated: 7/10/2025, 8:55:57 AM
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_count = 0, odd_count = 0;   
        for (int pos : position) {
            if (pos % 2 == 0) {
                even_count++;
            } else {
                odd_count++;
            }
        }
    return Math.min(even_count, odd_count);
    }
}