// Last updated: 12/1/2025, 9:00:29 AM
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long totalEnergy = 0;
4        for (int battery : batteries) totalEnergy += battery;
5        Arrays.sort(batteries);
6        for (int i = batteries.length - 1; i >= 0; i--) {
7            if (batteries[i] > totalEnergy / n) {
8                totalEnergy -= batteries[i];
9                n--;
10            } else break;
11        }
12        return totalEnergy / n;
13    }
14}