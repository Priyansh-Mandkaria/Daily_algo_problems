// Last updated: 12/21/2025, 3:13:38 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5        char[][] a = new char[n][];
6        for (int i = 0; i < n; i++) {
7            a[i] = strs[i].toCharArray();
8        }
9        boolean[] resolved = new boolean[n - 1];
10        int unresolved = n - 1;
11        int deletions = 0;
12        for (int col = 0; col < m && unresolved > 0; col++) {
13            boolean needDelete = false;
14            for (int row = 0; row < n - 1; row++) {
15                if (!resolved[row] && a[row][col] > a[row + 1][col]) {
16                    needDelete = true;
17                    break;
18                }
19            }
20            if (needDelete) {
21                deletions++;
22                continue;
23            }
24            for (int row = 0; row < n - 1; row++) {
25                if (!resolved[row] && a[row][col] < a[row + 1][col]) {
26                    resolved[row] = true;
27                    unresolved--;
28                }
29            }
30        }
31        return deletions;
32    }
33}