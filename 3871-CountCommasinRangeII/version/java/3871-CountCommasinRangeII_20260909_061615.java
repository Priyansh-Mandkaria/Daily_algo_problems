// Last updated: 9/9/2026, 6:16:15 AM
1class Solution {
2    public long countCommas(long n) {
3        if (n <= 999) return 0;
4        long totalCommas = 0;
5        long start = 1000;
6        while (start <= n) {
7            totalCommas += n - start + 1;
8            start *= 1000;
9        }
10        return totalCommas;
11    }
12}