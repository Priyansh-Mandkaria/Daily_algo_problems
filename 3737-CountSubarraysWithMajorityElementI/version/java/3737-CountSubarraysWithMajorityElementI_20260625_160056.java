// Last updated: 6/25/2026, 4:00:56 PM
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int ans = 0;
5        for (int l = 0; l < n; l++) {
6            int targetCount = 0;
7            for (int r = l; r < n; r++) {
8                if (nums[r] == target) {
9                    targetCount++;
10                }
11                int len = r - l + 1;
12                if (targetCount > len / 2) {
13                    ans++;
14                }
15            }
16        }
17        return ans;
18    }
19}