// Last updated: 7/10/2025, 8:54:26 AM
class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i] > nums[i - 1] ? curr + nums[i] : nums[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}