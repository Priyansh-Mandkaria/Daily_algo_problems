// Last updated: 1/12/2026, 10:06:36 AM
1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int ans = 0;
4        for(int i = 1; i < points.length; i++) {
5            ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
6        }
7        return ans;
8    }
9}