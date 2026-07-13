// Last updated: 7/13/2026, 10:44:42 AM
1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3       int n = intervals.length;
4        List<int[]> res = new ArrayList<>();
5        int i = 0;
6        while (i < n && intervals[i][1] < newInterval[0]) {
7            res.add(intervals[i]);
8            i++;
9        }
10
11        while (i < n && intervals[i][0] <= newInterval[1]) {
12            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
13            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
14            i++;
15        }
16        res.add(newInterval);
17        while (i < n) {
18            res.add(intervals[i]);
19            i++;
20        }
21        return res.toArray(new int[res.size()][]);
22    }
23}