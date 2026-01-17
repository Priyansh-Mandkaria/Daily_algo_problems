// Last updated: 1/17/2026, 3:03:52 PM
1class Solution {
2    public long largestSquareArea(int[][] bl, int[][] tr) {
3        int s = 0;
4        int n = bl.length;
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                int minX = Math.max(bl[i][0], bl[j][0]);
9                int maxX = Math.min(tr[i][0], tr[j][0]);
10                int minY = Math.max(bl[i][1], bl[j][1]);
11                int maxY = Math.min(tr[i][1], tr[j][1]);
12
13                if (minX < maxX && minY < maxY) {
14                    int len = Math.min(maxX - minX, maxY - minY);
15                    s = Math.max(s, len);
16                }
17            }
18        }
19
20        return (long) s * s;
21    }
22}
23