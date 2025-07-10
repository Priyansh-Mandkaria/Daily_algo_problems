// Last updated: 7/10/2025, 8:58:40 AM
class Solution {
    public int singleNumber(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count ^= i;//bit manupulation
        }
        return count;
    }
}