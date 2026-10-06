// Last updated: 10/6/2026, 2:39:07 PM
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int open = 0, add = 0;
4        for (char c : s.toCharArray()) {
5            if (c == '(') {
6                open++;
7            } else {
8                if (open > 0) {
9                    open--;
10                } else {
11                    add++;
12                }
13            }
14        }
15        return add + open;
16    }
17}