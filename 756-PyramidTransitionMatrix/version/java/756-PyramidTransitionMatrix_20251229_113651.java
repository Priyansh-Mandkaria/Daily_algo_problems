// Last updated: 12/29/2025, 11:36:51 AM
1class Solution {
2    public boolean pyramidTransition(String bottom, List<String> allowed) {
3        return new Solver(allowed, bottom.length()).canDo(bottom);
4    }
5
6    static final class Solver {
7        final int[][] cache;
8        final int[][][] allowed = new int[6][6][];
9
10        public Solver(List<String> allowed, int len) {
11            int[][] cnt = new int[6][6];
12
13            // Count transitions
14            for (String a : allowed) {
15                cnt[a.charAt(0) - 'A'][a.charAt(1) - 'A']++;
16            }
17
18            // Allocate transition arrays
19            for (int i = 0; i < 6; i++) {
20                for (int j = 0; j < 6; j++) {
21                    this.allowed[i][j] = new int[cnt[i][j]];
22                }
23            }
24
25            // Initialize cache
26            this.cache = new int[len][];
27            int size = 6 * 6;
28            for (int i = 3; i < len; i++) {
29                cache[i] = new int[size *= 6];
30            }
31
32            // Fill transitions
33            for (String a : allowed) {
34                int x = a.charAt(0) - 'A';
35                int y = a.charAt(1) - 'A';
36                int z = a.charAt(2) - 'A';
37                this.allowed[x][y][--cnt[x][y]] = z;
38            }
39        }
40
41        boolean canDo(String s) {
42            int[] arr = new int[s.length()];
43            for (int i = 0; i < arr.length; i++) {
44                arr[i] = s.charAt(i) - 'A';
45            }
46            return s.length() == 2
47                    ? allowed[arr[0]][arr[1]].length > 0
48                    : compute(arr, arr.length);
49        }
50
51        boolean canDo(int[] arr, int len) {
52            if (len == 2) {
53                return allowed[arr[0]][arr[1]].length > 0;
54            }
55            int key = encode(arr, len);
56            int cached = cache[len][key];
57            if (cached != 0) return cached == 1;
58
59            boolean result = compute(arr, len);
60            cache[len][key] = result ? 1 : 2;
61            return result;
62        }
63
64        private int encode(int[] arr, int len) {
65            int r = arr[0];
66            for (int i = 1; i < len; i++) {
67                r = r * 6 + arr[i];
68            }
69            return r;
70        }
71
72        boolean compute(int[] arr, int len) {
73            for (int i = 1; i < len; i++) {
74                if (allowed[arr[i - 1]][arr[i]].length == 0) {
75                    return false;
76                }
77            }
78            return build(new int[len], 0, arr, 0, len);
79        }
80
81        boolean build(int[] prefix, int plen, int[] suffix, int sidx, int slen) {
82            if (plen > 1 && !canDo(prefix, plen)) return false;
83
84            if (sidx + 1 < slen) {
85                for (int next : allowed[suffix[sidx]][suffix[sidx + 1]]) {
86                    prefix[plen] = next;
87                    if (build(prefix, plen + 1, suffix, sidx + 1, slen)) {
88                        return true;
89                    }
90                }
91            } else {
92                return canDo(prefix, plen);
93            }
94            return false;
95        }
96    }
97}