// Last updated: 12/24/2025, 10:56:30 PM
1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        Arrays.sort(capacity);
4        int ans = 0, sum = 0;
5        for(int i = 0; i < apple.length; i++) sum += apple[i];
6        for(int i = capacity.length - 1; i >= 0; i--) {
7            sum -= capacity[i];
8            ans++;
9            if(sum <= 0) return ans;
10        }
11        return ans;
12    }
13}