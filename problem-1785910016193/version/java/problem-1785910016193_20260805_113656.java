// Last updated: 8/5/2026, 11:36:56 AM
1class Solution {
2    public int minBitFlips(int start, int goal) {
3        String sa = Integer.toBinaryString(start);
4        String ga = Integer.toBinaryString(goal);
5        while (sa.length() < ga.length()) {
6            sa = "0" + sa;
7        }
8        while (ga.length() < sa.length()) {
9            ga = "0" + ga;
10        }
11        int cnt = 0;
12        for (int i = 0; i < sa.length(); i++) {
13            if (sa.charAt(i) != ga.charAt(i)) {
14                cnt++;
15            }
16        }
17        return cnt;
18    }
19}
20