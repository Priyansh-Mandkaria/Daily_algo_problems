// Last updated: 2/14/2026, 1:52:02 PM
1class Solution {
2    public int longestBalanced(String s) {
3        char[] c = s.toCharArray();
4        int n = c.length;
5        
6        int cur_a = 0, cur_b = 0, cur_c = 0;        
7        int max_a = 0, max_b = 0, max_c = 0;
8
9        for (int i = 0; i < n; i++) {
10            if (c[i] == 'a') {
11                cur_a = (i > 0 && c[i-1] == 'a') ? cur_a + 1 : 1;
12                max_a = Math.max(max_a, cur_a);
13            } else if (c[i] == 'b') {
14                cur_b = (i > 0 && c[i-1] == 'b') ? cur_b + 1 : 1;
15                max_b = Math.max(max_b, cur_b);
16            } else { 
17                cur_c = (i > 0 && c[i-1] == 'c') ? cur_c + 1 : 1;
18                max_c = Math.max(max_c, cur_c);
19            }
20        }
21        
22        int res = Math.max(Math.max(max_a, max_b), max_c);
23        
24        res = Math.max(res, find2(c, 'a', 'b'));
25        res = Math.max(res, find2(c, 'a', 'c'));
26        res = Math.max(res, find2(c, 'b', 'c'));
27        
28        res = Math.max(res, find3(c));
29        
30        return res;
31    }
32    
33    private int find2(char[] c, char x, char y) {
34        int n = c.length, max_len = 0;
35        int[] first = new int[2 * n + 1];
36        Arrays.fill(first, -2);
37        
38        int clear_idx = -1, diff = n;
39        first[diff] = -1;
40        
41        for (int i = 0; i < n; i++) {
42            if (c[i] != x && c[i] != y) {
43                clear_idx = i;
44                diff = n;
45                first[diff] = clear_idx;
46            } else {
47                if (c[i] == x) diff++;
48                else diff--;
49                
50                if (first[diff] < clear_idx) {
51                    first[diff] = i;
52                } else {
53                    max_len = Math.max(max_len, i - first[diff]);
54                }
55            }
56        }
57        
58        return max_len;
59    }
60    
61    private int find3(char[] c) {
62        long state = Long.MAX_VALUE / 2;
63        Map<Long, Integer> first = new HashMap<>();
64        first.put(state, -1);
65    
66        int max_len = 0;
67    
68        for (int i = 0; i < c.length; i++) {
69            if (c[i] == 'a') state += 1_000_001;
70            else if (c[i] == 'b') state -= 1_000_000;
71            else state--;
72        
73            if (first.containsKey(state)) {
74                max_len = Math.max(max_len, i - first.get(state));
75            } else {
76                first.put(state, i);
77            }
78        }
79    
80        return max_len;
81    }
82}