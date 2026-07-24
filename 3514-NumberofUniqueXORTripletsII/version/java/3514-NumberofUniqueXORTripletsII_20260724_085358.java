// Last updated: 7/24/2026, 8:53:58 AM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int m = 0;
4        for (int v : nums) {
5            m = Math.max(m, v);
6        }
7        int u = 1;
8        while (u <= m) {
9            u <<= 1;
10        }
11        boolean[] one = new boolean[u];
12        boolean[] two = new boolean[u];
13        boolean[] three = new boolean[u];
14        for (int v : nums) {
15            one[v] = true;
16            for (int x = 0; x < u; x++) {
17                if (one[x]) {
18                    two[x ^ v] = true;
19                }
20            }
21        }
22        for (int v : nums) {
23            for (int x = 0; x < u; x++) {
24                if (two[x]) {
25                    three[x ^ v] = true;
26                }
27            }
28        }
29        int ans = 0;
30        for (boolean b : three) {
31            if (b) {
32                ans++;
33            }
34        }
35        return ans;
36    }
37}