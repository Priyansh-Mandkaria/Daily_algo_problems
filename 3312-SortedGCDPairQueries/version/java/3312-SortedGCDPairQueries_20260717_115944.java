// Last updated: 7/17/2026, 11:59:44 AM
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int n = nums.length;
4        int maxE = 0;
5        for (int num : nums) {
6            maxE = Math.max(maxE, num);
7        }
8        long[] freq = new long[maxE + 1];
9        for (int num : nums) {
10            freq[num]++;
11        }
12        long[] exact = new long[maxE + 1];
13        for (int gcd = maxE; gcd >= 1; gcd--) {
14            long cnt = 0;
15            for (int times = gcd; times <= maxE; times += gcd) {
16                cnt += freq[times];
17            }
18            exact[gcd] = cnt * (cnt - 1) / 2;
19            for (int times = 2 * gcd; times <= maxE; times += gcd) {
20                exact[gcd] -= exact[times];
21            }
22        }
23        long[] pref = new long[maxE + 1];
24        for (int gcd = 1; gcd <= maxE; gcd++) {
25            pref[gcd] = pref[gcd - 1] + exact[gcd];
26        }
27        int[] result = new int[queries.length];
28        for (int i = 0; i < queries.length; i++) {
29            long q = queries[i];
30            int left = 1, right = maxE;
31            while (left < right) {
32                int mid = left + (right - left) / 2;
33                if (pref[mid] > q) {
34                    right = mid;
35                } else {
36                    left = mid + 1;
37                }
38            }
39            result[i] = left;
40        }
41        return result;
42    }
43}