// Last updated: 8/24/2026, 8:29:38 AM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4        for (int i = 1; i < n; i++) {
5            stones[i] += stones[i - 1];
6        }
7        int best = stones[n - 1];
8        for (int i = n - 2; i >= 1; i--) {
9            best = Math.max(best,stones[i] - best);
10        }
11        return best;
12    }
13}