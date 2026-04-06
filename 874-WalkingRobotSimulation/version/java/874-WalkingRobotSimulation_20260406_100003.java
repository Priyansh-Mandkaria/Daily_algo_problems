// Last updated: 4/6/2026, 10:00:03 AM
1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        // store obstacles
4        Set<Long> st = new HashSet<>();
5
6        for (int[] o : obstacles) {
7            long key = (((long)o[0]) << 32) | (o[1] & 0xffffffffL);
8            st.add(key);
9        }
10
11        int[][] dir = {
12            {0,1}, {1,0}, {0,-1}, {-1,0}
13        };
14
15        int d = 0; // North
16        int x = 0, y = 0;
17        int ans = 0;
18
19        for (int cmd : commands) {
20            if (cmd == -1) {
21                d = (d + 1) % 4;
22            } 
23            else if (cmd == -2) {
24                d = (d + 3) % 4;
25            } 
26            else {
27                for (int i = 0; i < cmd; i++) {
28                    int nx = x + dir[d][0];
29                    int ny = y + dir[d][1];
30
31                    long key = (((long)nx) << 32) | (ny & 0xffffffffL);
32
33                    if (st.contains(key)) break;
34
35                    x = nx;
36                    y = ny;
37
38                    ans = Math.max(ans, x*x + y*y);
39                }
40            }
41        }
42
43        return ans;
44    }
45}