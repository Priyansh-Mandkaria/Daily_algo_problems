// Last updated: 3/6/2026, 3:20:09 AM
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length(), c = 0, j = 0;
4        for(char ch : s.toCharArray()) {
5            if(ch - '0' == j) c++;
6            j ^= 1;
7        }
8        return Math.min(c, n - c);
9    }
10}