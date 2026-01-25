// Last updated: 1/25/2026, 3:48:55 PM
1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        int n = nums.length;
4        Arrays.sort(nums);
5        int ans = nums[k - 1] - nums[0];
6        for (int i = 0; i + k <= n; i++) {
7            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
8        }
9        return ans;
10    }
11}