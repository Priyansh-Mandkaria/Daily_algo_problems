// Last updated: 7/10/2025, 8:51:57 AM
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }
        return maxBeauty;
    }
}