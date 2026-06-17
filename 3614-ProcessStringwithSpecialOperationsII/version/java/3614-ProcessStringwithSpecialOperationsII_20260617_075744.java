// Last updated: 6/17/2026, 7:57:44 AM
1class Solution {
2    public char processStr(String s, long k) {
3        int n = s.length();
4        long[] lengths = new long[n + 1];  // length after each operation
5        lengths[0] = 0;
6
7        for (int i = 0; i < n; i++) {
8            char ch = s.charAt(i);
9            if (ch >= 'a' && ch <= 'z') {
10                lengths[i + 1] = lengths[i] + 1;
11            } else if (ch == '*') {
12                lengths[i + 1] = Math.max(0, lengths[i] - 1);
13            } else if (ch == '#') {
14                if (lengths[i] * 2 >= 1e15) 
15                    lengths[i + 1] = (long) 1e15;  // avoid overflow
16                else
17                    lengths[i + 1] = lengths[i] * 2;
18            } else if (ch == '%') {
19                lengths[i + 1] = lengths[i];
20            }
21        }
22
23        if (k >= lengths[n]) return '.';
24
25        for (int i = n - 1; i >= 0; i--) {
26            char ch = s.charAt(i);
27            if (ch >= 'a' && ch <= 'z') {
28                if (k == lengths[i]) return ch;
29                else if (k < lengths[i]) continue;
30            } else if (ch == '*') {
31                if (k >= lengths[i]) k++;  // simulate deletion, adjust forward
32            } else if (ch == '#') {
33                if (k >= lengths[i]) {
34                    if (k < 2 * lengths[i]) {
35                        k = k % lengths[i];  // find where it came from
36                    }
37                }
38            } else if (ch == '%') {
39                if (lengths[i] > 0)
40                    k = lengths[i] - 1 - k;
41            }
42        }
43
44        return '.';  // shouldn't reach here
45    }
46}