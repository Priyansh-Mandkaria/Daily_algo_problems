// Last updated: 9/20/2026, 12:23:23 PM
1class Solution {
2    public int reverseDegree(String s) {
3        int rev = 0;
4        int n = s.length();
5        for (int i = 0; i < n; ++i)
6            rev += ((26 - (s.charAt(i) - 'a')) * (i + 1));
7        return rev;
8    }
9}