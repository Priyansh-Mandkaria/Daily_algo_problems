// Last updated: 7/30/2026, 10:21:14 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int ans = 0;
4        for(int i = 0; i < word.length(); i++)
5            ans += (i / 8) + 1;
6        return ans;
7    }
8}