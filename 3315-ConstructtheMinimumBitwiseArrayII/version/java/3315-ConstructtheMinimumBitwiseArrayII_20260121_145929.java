// Last updated: 1/21/2026, 2:59:29 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] ans = new int[n];   
5        for (int i = 0; i < n; i++) {
6            int x = nums.get(i);
7            if (x == 2) {
8                ans[i] = -1;
9            } else {
10                int bit = (x + 1) & -(x + 1);
11                ans[i] = x - (bit >> 1);
12            }
13        }
14        return ans;
15    }
16}