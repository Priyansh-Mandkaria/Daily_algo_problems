// Last updated: 5/14/2026, 1:07:04 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5        for (int i = 0; i < n - 1; i++) {
6            if (nums[i] != i + 1)
7                return false;
8        }
9        return nums[n - 1] == n - 1;
10    }
11}