// Last updated: 6/15/2026, 10:02:47 PM
1class Solution {
2    public String convert(String s, int numRows) {
3       if (numRows == 1 || numRows >= s.length()) {
4            return s;
5        }
6        int idx = 0, d = 1;
7        List<Character>[] rows = new ArrayList[numRows];
8        for (int i = 0; i < numRows; i++) {
9            rows[i] = new ArrayList<>();
10        }
11        for (char c : s.toCharArray()) {
12            rows[idx].add(c);
13            if (idx == 0) {
14                d = 1;
15            } else if (idx == numRows - 1) {
16                d = -1;
17            }
18            idx += d;
19        }
20        StringBuilder result = new StringBuilder();
21        for (List<Character> row : rows) {
22            for (char c : row) {
23                result.append(c);
24            }
25        }
26        return result.toString();        
27    }
28}