// Last updated: 11/30/2025, 3:08:19 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        long total = 0;
4        for (int num : nums) total += num;
5        long target = total % p;
6        if (target == 0) return 0;
7        Map<Integer, Integer> mMap = new HashMap<>();
8        mMap.put(0, -1);
9        long prefix = 0;
10        int res = nums.length;
11        for (int i = 0; i < nums.length; i++) {
12            prefix = (prefix + nums[i]) % p;
13            int need = (int)((prefix - target + p) % p);
14            if (mMap.containsKey(need)) {
15                res = Math.min(res, i - mMap.get(need));
16            }
17            mMap.put((int)prefix, i);
18        }
19        return res == nums.length ? -1 : res;
20    }
21}