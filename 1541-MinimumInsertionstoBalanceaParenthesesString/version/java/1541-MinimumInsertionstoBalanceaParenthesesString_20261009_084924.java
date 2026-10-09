// Last updated: 10/9/2026, 8:49:24 AM
1class Solution {
2    public int minInsertions(String s) {
3        int ans = 0, x = 0;
4        int n = s.length();
5        for (int i = 0; i < n; ++i) {
6            if (s.charAt(i) == '(') {
7                ++x;
8            } else {
9                if (i < n - 1 && s.charAt(i + 1) == ')') {
10                    ++i;
11                } else {
12                    ++ans;
13                }
14                if (x == 0) {
15                    ++ans;
16                } else {
17                    --x;
18                }
19            }
20        }
21        ans += x << 1;
22        return ans;
23    }
24}