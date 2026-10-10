// Last updated: 10/10/2026, 8:25:35 PM
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int[] d = new int[100001];
4        long k = (long) k1 + k2, sum = 0;
5        int max = 0;
6        for (int i = 0; i < nums1.length; i++) {
7            int x = Math.abs(nums1[i] - nums2[i]);
8            d[x]++;
9            sum += x;
10            max = Math.max(max, x);
11        }
12        if (sum <= k) return 0;
13        for (int i = max; i > 0 && k > 0; i--) {
14            long move = Math.min(k, d[i]);
15            d[i] -= move;
16            d[i - 1] += move;
17            k -= move;
18        }
19        long ans = 0;
20        for (int i = 0; i <= max; i++)
21            ans += (long) i * i * d[i];
22        return ans;
23    }
24}