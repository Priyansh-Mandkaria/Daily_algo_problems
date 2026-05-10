// Last updated: 5/10/2026, 1:14:17 PM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int[] dp = new int[nums.length];
4        Arrays.fill(dp, -1);
5        dp[0] = 0;
6        for (int i = 0; i < nums.length; i++) {
7            if (i > 0 && dp[i] <= 0) {
8                continue;
9            }
10            for (int j = i + 1; j < nums.length; j++) {
11                if (Math.abs(nums[i] - nums[j]) <= Math.abs(target)) {
12                    dp[j] = Math.max(dp[j], dp[i] + 1);
13                }
14            }
15        }
16        return dp[nums.length - 1];
17    }
18}