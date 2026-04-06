// Last updated: 4/6/2026, 10:00:38 AM
1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        Set<Long> st = new HashSet<>();
4        for (int[] o : obstacles) {
5            long key = (((long)o[0]) << 32) | (o[1] & 0xffffffffL);
6            st.add(key);
7        }
8        int[][] dir = {
9            {0,1}, {1,0}, {0,-1}, {-1,0}
10        };
11        int d = 0;
12        int x = 0, y = 0;
13        int ans = 0;
14        for (int cmd : commands) {
15            if (cmd == -1) {
16                d = (d + 1) % 4;
17            } 
18            else if (cmd == -2) {
19                d = (d + 3) % 4;
20            } 
21            else {
22                for (int i = 0; i < cmd; i++) {
23                    int nx = x + dir[d][0];
24                    int ny = y + dir[d][1];
25                    long key = (((long)nx) << 32) | (ny & 0xffffffffL);
26                    if (st.contains(key)) break;
27                    x = nx;
28                    y = ny;
29                    ans = Math.max(ans, x*x + y*y);
30                }
31            }
32        }
33        return ans;
34    }
35}