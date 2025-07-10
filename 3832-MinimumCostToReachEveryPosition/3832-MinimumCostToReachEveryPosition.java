// Last updated: 7/10/2025, 8:49:27 AM
class Solution {
    public int[] minCosts(int[] cost) {
        int min = cost[0];
        int[] ans = new int[cost.length];
        ans[0] = min;
        for(int i = 1; i < cost.length; i++) {
            min = Math.min(min, cost[i]);
            ans[i] = min;
        }
        return ans;
    }
}