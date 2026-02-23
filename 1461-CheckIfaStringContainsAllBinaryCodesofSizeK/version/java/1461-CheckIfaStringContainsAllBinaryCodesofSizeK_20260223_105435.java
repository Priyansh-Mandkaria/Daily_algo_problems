// Last updated: 2/23/2026, 10:54:35 AM
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        int req = 1 << k;
4        boolean[] seen = new boolean[req];
5        int mask = req - 1;
6        int hash = 0;
7        for (int i = 0; i < s.length(); ++i) {
8            hash = ((hash << 1) & mask) | (s.charAt(i) & 1);
9            if (i >= k - 1 && !seen[hash]) {
10                seen[hash] = true;
11                req--;
12                if (req == 0) return true;
13            }
14        }
15        return false;
16    }
17}