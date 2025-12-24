// Last updated: 12/25/2025, 12:49:57 AM
1class Solution {
2    public int maxDepth(String s) {
3        int cnt = 0;
4        int max = 0;
5        for(char c : s.toCharArray()){
6            if(c == '(')cnt++;
7            else if(c == ')')cnt--;
8            max = Math.max(max,cnt);
9        }
10        return max;
11    }
12}