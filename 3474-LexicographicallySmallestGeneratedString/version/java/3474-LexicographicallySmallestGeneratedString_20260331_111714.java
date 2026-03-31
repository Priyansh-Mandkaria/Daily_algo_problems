// Last updated: 3/31/2026, 11:17:14 AM
1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length(), m = str2.length(), L = n + m - 1;
4        char[] word = new char[L];
5        boolean[] forced = new boolean[L];
6        Arrays.fill(word, '\0');
7        for (int i = 0; i < n; i++) {
8            if (str1.charAt(i) == 'T') {
9                for (int j = 0; j < m; j++) {
10                    int pos = i + j;
11                    char c = str2.charAt(j);
12                    if (word[pos] == '\0') {
13                        word[pos] = c;
14                        forced[pos] = true;
15                    } else if (word[pos] != c) {
16                        return "";
17                    }
18                }
19            }
20        }
21        for (int i = 0; i < L; i++) {
22            if (word[i] == '\0') {
23                word[i] = 'a';
24            }
25        }
26        boolean modified = true;
27        while (modified) {
28            modified = false;
29            for (int i = 0; i < n; i++) {
30                if (str1.charAt(i) == 'F') {
31                    boolean eq = true;
32                    for (int j = 0; j < m; j++) {
33                        if (word[i + j] != str2.charAt(j)) {
34                            eq = false;
35                            break;
36                        }
37                    }
38                    if (eq) {
39                        boolean done = false;
40                        for (int j = m - 1; j >= 0; j--) {
41                            int pos = i + j;
42                            if (!forced[pos]) {
43                                for (char c = (char) (word[pos] + 1); c <= 'z'; c++) {
44                                    if (c != str2.charAt(j)) {
45                                        word[pos] = c;
46                                        for (int k = pos + 1; k < L; k++) {
47                                            if (!forced[k]) {
48                                                word[k] = 'a';
49                                            }
50                                        }
51                                        done = true;
52                                        break;
53                                    }
54                                }
55                                if (done)
56                                    break;
57                            }
58                        }
59                        if (!done)
60                            return "";
61                        modified = true;
62                        break;
63                    }
64                }
65            }
66        }
67        return new String(word);
68    }
69}