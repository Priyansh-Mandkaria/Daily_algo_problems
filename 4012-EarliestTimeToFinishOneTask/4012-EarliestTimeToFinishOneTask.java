// Last updated: 6/22/2026, 1:34:32 PM
class Solution {
    public int earliestTime(int[][] tasks) {
        int minans = Integer.MAX_VALUE;
        for(int i = 0 ; i < tasks.length ; i++){
            minans = Math.min(minans, tasks[i][0] + tasks[i][1]);
        }
        return minans;
    }
}