// Last updated: 6/22/2026, 1:34:18 PM
class Solution {
    public int climbStairs(int n, int[] cst) {
        long tan = 0;
        long nez = Long.MAX_VALUE;
        long zen = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            long fTan =(tan == Long.MAX_VALUE) ? Long.MAX_VALUE : tan+ 1;
            long fNez =(nez == Long.MAX_VALUE) ? Long.MAX_VALUE : nez+ 4;
            long fZen =(zen == Long.MAX_VALUE) ? Long.MAX_VALUE : zen+ 9;
            long cur = cst[i - 1] + Math.min(fTan, Math.min(fNez, fZen));
            zen = nez;
            nez = tan;
            tan = cur;
        }
        return (int) tan;
    }
}
