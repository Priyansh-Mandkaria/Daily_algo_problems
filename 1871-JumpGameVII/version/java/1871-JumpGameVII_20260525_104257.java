// Last updated: 5/25/2026, 10:42:57 AM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        if (s.charAt(n - 1) == '1') return false;
5        boolean[] dp = new boolean[n];
6        dp[0] = true;
7        int reachable = 0;
8        for (int i = 1; i < n; i++) {
9            if (i >= minJump && dp[i - minJump]) reachable++;
10            if (i > maxJump && dp[i - maxJump - 1]) reachable--;
11            if (reachable > 0 && s.charAt(i) == '0')
12                dp[i] = true;
13        }
14        return dp[n - 1];
15    }
16}