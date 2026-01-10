// Last updated: 1/10/2026, 2:42:13 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int m = s1.length(), n = s2.length();
4        int[][] dp = new int[m + 1][n + 1];
5
6        for (int i = m - 1; i >= 0; i--) {
7            for (int j = n - 1; j >= 0; j--) {
8                if (s1.charAt(i) == s2.charAt(j)) {
9                    dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
10                } else {
11                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
12                }
13            }
14        }
15
16        int total = 0;
17        for (char c : s1.toCharArray()) total += c;
18        for (char c : s2.toCharArray()) total += c;
19
20        return total - 2 * dp[0][0];
21    }
22}