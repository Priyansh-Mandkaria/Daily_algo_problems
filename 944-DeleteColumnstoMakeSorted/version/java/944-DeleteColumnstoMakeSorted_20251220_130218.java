// Last updated: 12/20/2025, 1:02:18 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int rows = strs.length;
4        int cols = strs[0].length();
5        int deletions = 0;
6        for (int c = 0; c < cols; c++) {
7            for (int r = 0; r < rows - 1; r++) {
8                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
9                    deletions++;
10                    break;
11                }
12            }
13        }
14        return deletions;
15    }
16}