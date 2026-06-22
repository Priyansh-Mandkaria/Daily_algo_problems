// Last updated: 6/22/2026, 1:35:15 PM
class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int a = ls.length;
        int b = ld.length;
        int c = ws.length;
        int d = wd.length;
        int pa = Integer.MAX_VALUE;
        int pb = Integer.MAX_VALUE;
        int fp = Integer.MAX_VALUE;
        for (int i = 0; i < a; i++) pa = Math.min(pa, ls[i] + ld[i]);
        for (int j = 0; j < c; j++) pb = Math.min(pb, ws[j] + wd[j]);
        for (int j = 0; j < c; j++) fp = Math.min(fp, Math.max(ws[j], pa) + wd[j]);
        for (int i = 0; i < a; i++) fp = Math.min(fp, Math.max(ls[i], pb) + ld[i]);
        return fp;
    }
}