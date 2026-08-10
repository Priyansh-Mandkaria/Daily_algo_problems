// Last updated: 8/10/2026, 9:50:49 AM
1class Solution {
2    public int distributeCandies(int n, int limit) {
3        int min = Math.max(0, n - 2 * limit); 
4        int max = Math.min(n, limit);        
5        int ways = 0;
6        for (int i = min; i <= max; i++) {
7            int N = n - i; 
8            int minCh2 = Math.max(0, N - limit); 
9            int maxCh2 = Math.min(N, limit);     
10            ways += maxCh2 - minCh2 + 1;
11        }
12        return ways;
13    }
14}