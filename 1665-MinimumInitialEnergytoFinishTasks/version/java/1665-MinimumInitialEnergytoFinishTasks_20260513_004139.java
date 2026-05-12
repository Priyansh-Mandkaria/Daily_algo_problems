// Last updated: 5/13/2026, 12:41:39 AM
1class Solution {
2    public int minimumEffort(int[][] tasks) {
3        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
4        int curr = 0;
5        int ans  = 0;
6        for (int[] task : tasks) {
7            int actual  = task[0];
8            int minimum = task[1];
9            if (curr < minimum) {
10                ans  += (minimum - curr);
11                curr  = minimum;
12            }
13            curr -= actual;
14        }
15        return ans;
16    }
17}