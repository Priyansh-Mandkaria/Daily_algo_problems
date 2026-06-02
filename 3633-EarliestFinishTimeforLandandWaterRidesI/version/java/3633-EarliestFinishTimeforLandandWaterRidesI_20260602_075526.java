// Last updated: 6/2/2026, 7:55:26 AM
1class Solution {
2    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
3        int a = ls.length;
4        int b = ld.length;
5        int c = ws.length;
6        int d = wd.length;
7        int pa = Integer.MAX_VALUE;
8        int pb = Integer.MAX_VALUE;
9        int fp = Integer.MAX_VALUE;
10        for (int i = 0; i < a; i++) pa = Math.min(pa, ls[i] + ld[i]);
11        for (int j = 0; j < c; j++) pb = Math.min(pb, ws[j] + wd[j]);
12        for (int j = 0; j < c; j++) fp = Math.min(fp, Math.max(ws[j], pa) + wd[j]);
13        for (int i = 0; i < a; i++) fp = Math.min(fp, Math.max(ls[i], pb) + ld[i]);
14        return fp;
15    }
16}