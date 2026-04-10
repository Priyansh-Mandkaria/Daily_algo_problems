// Last updated: 4/10/2026, 1:50:26 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int len = nums.length;
4        int[] last2 = new int[len];
5        int res = 200;
6        for (int i = 0; i < len; i++) {
7            int val = nums[i] - 1;
8            int pos = i + 1, pack = last2[val];
9            int old = pack & 255, cur = pack >> 8;
10            last2[val] = cur | (pos << 8);
11            if (old > 0)
12                res = Math.min(res, (pos - old) << 1);
13        }
14        return res == 200 ? -1 : res;
15    }
16}