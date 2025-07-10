// Last updated: 7/10/2025, 8:49:48 AM
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[(i + 1) % n]);
            max = Math.max(max, diff);
        }
        return max; 
    }
}