// Last updated: 4/24/2026, 5:31:05 AM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int count_L = 0;
4        int count_R = 0;
5        int blank = 0;
6        for (int i = 0; i < moves.length(); i++) {
7            char move = moves.charAt(i);
8            if (move == 'L') {
9                count_L++;
10            } else if (move == 'R') {
11                count_R++;
12            } else {
13                blank++;
14            }
15        }
16        int netDisplacement = Math.abs(count_L - count_R);
17        return netDisplacement + blank;
18    }
19}