// Last updated: 12/24/2025, 10:57:15 PM
1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        int[] hash = new int[51];
4        int ans = 0, sum = 0;
5        for(int i = 0; i < apple.length; i++) sum += apple[i];
6        for(int i = 0; i < capacity.length; i++) hash[capacity[i]]++;
7        for(int i = 50; i > 0; i--) {
8            while(hash[i] > 0) {
9                sum -= i;
10                hash[i]--;
11                ans++;
12                if(sum <= 0) return ans;
13            }
14        }
15        return ans;
16    }
17}