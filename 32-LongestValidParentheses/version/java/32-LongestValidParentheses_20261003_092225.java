// Last updated: 10/3/2026, 9:22:25 AM
1class Solution {
2    public int longestValidParentheses(String s) {
3         int n = s.length();
4        if (n == 0) {
5            return 0;
6        }
7        int[] dp = new int[n];
8        int maxLength = 0;
9        for (int i = 1; i < n; i++) {
10            if (s.charAt(i) == ')') {
11                if (s.charAt(i - 1) == '(') {
12                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
13                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
14                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0) + 2;
15                }
16                maxLength = Math.max(maxLength, dp[i]);
17            }
18        }
19        return maxLength;
20    }
21}