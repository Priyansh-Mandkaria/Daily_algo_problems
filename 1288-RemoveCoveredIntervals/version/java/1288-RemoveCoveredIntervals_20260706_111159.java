// Last updated: 7/6/2026, 11:11:59 AM
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> {
4            if (a[0] != b[0])
5                return a[0] - b[0];
6            return b[1] - a[1];
7        });
8        int ans = intervals.length;
9        int low = intervals[0][0];
10        int high = intervals[0][1];
11        for (int i = 1; i < intervals.length; i++) {
12
13            if (intervals[i][0] == low || intervals[i][1] <= high) {
14                ans--;
15            } else {
16                low = intervals[i][0];
17                high = intervals[i][1];
18            }
19        }
20        return ans;
21    }
22}