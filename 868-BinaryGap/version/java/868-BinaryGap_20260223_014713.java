// Last updated: 2/23/2026, 1:47:13 AM
1class Solution {
2    public int binaryGap(int n) {
3        n >>= Integer.numberOfTrailingZeros(n);
4        if (n == 1) return 0;
5        int maxGap = 0, gap = 0;
6        while (n > 0) {
7            if ((n & 1) == 1) {
8                maxGap = Math.max(maxGap, gap);
9                gap = 0;
10            } else
11                gap++;
12            n >>= 1;
13        }
14        return maxGap + 1;
15    }
16}