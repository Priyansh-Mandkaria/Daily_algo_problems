// Last updated: 3/28/2026, 5:29:22 PM
1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length; int[] word = new int[n]; word[0] = 0;  
4        for (int i = 1; i < n; i++) {
5            int forbidden_mask = 0, assigned = -1;
6            for (int j = 0; j < i; j++) {
7                if (lcp[i][j] > 0) {
8                    assigned = word[j];
9                    break;
10                } else if (lcp[i][j] == 0) {
11                    forbidden_mask |= 1 << word[j];
12                }
13            }
14            if (assigned != -1) {
15                word[i] = assigned;
16            } else {
17                int letter = 0;
18                while (letter < 26 && ((forbidden_mask >> letter) & 1) == 1) letter++;
19                if (letter >= 26) return "";
20                word[i] = letter;
21            }
22        }
23        for (int i = n - 1; i >= 0; i--) {
24            for (int j = n - 1; j >= 0; j--) {
25                if (word[i] != word[j]) {
26                    if (lcp[i][j] != 0) return "";
27                } else {
28                    if (i == n - 1 || j == n - 1) {
29                        if (lcp[i][j] != 1) return "";
30                    } else {
31                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) return "";
32                    }
33                }
34            }
35        }
36        char[] res = new char[n];
37        for (int i = 0; i < n; i++) {
38            res[i] = (char)('a' + word[i]);
39        }
40        return new String(res);
41    }
42}