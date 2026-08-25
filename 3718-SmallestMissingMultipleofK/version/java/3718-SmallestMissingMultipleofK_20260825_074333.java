// Last updated: 8/25/2026, 7:43:33 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        boolean[] contains = new boolean[201];
4        for (int ele : nums) {
5            contains[ele] = true;
6        }
7        int ans = k;
8        while (contains[ans]) {
9            ans += k;
10        }
11        return ans;
12    }
13}