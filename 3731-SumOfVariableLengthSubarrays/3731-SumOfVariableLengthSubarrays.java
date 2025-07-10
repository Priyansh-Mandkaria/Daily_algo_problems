// Last updated: 7/10/2025, 8:49:52 AM
class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                sum += nums[j];
            }
        }
        return sum;
    }
}