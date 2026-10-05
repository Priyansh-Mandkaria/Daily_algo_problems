// Last updated: 10/5/2026, 8:20:44 AM
1class Solution {
2    public int scoreOfParentheses(String S) {
3        return F(S, 0, S.length());
4    }
5    private int F(String S, int i, int j) {
6        int ans = 0, bal = 0;
7        for (int k = i; k < j; ++k) {
8            bal += S.charAt(k) == '(' ? 1 : -1;
9            if (bal == 0) {
10                if (k - i == 1) {
11                    ans++;
12                } else {
13                    ans += 2 * F(S, i + 1, k);
14                }
15                i = k + 1; 
16            }
17        }
18        return ans;
19    }
20}