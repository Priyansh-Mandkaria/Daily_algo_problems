// Last updated: 1/16/2026, 1:17:11 AM
1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        int maxConsecutiveHBars = 1;
4        int maxConsecutiveVBars = 1;
5        Arrays.sort(hBars);
6        Arrays.sort(vBars);
7        int hLength = hBars.length;
8        int vLength = vBars.length;
9        int tempH = 1;
10        int tempV = 1;
11        for (int i = 1; i < Math.max(hLength, vLength); i++) {
12            if (i < hLength && hBars[i] - hBars[i - 1] == 1) {
13                tempH++;
14            } else if (i < hLength) {
15                maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
16                tempH = 1;
17            }
18            if (i < vLength && vBars[i] - vBars[i - 1] == 1) {
19                tempV++;
20            } else if (i < vLength) {
21                maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);
22                tempV = 1;
23            }
24        }
25        maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
26        maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);
27        int squareLen = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;
28        return squareLen * squareLen;
29    }
30}