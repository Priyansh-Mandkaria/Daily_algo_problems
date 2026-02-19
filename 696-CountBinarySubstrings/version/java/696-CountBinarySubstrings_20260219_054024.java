// Last updated: 2/19/2026, 5:40:24 AM
1class Solution {
2    public int countBinarySubstrings(String s) {
3        int n = s.length();
4        int[] blocks = new int[n];
5        int idx = 0;
6        
7        int count = 1;
8        for (int i = 1; i < n; i++) {
9            if (s.charAt(i) == s.charAt(i - 1)) {
10                count++;
11            } else {
12                blocks[idx++] = count;
13                count = 1;
14            }
15        }
16        blocks[idx++] = count;
17        
18        int res = 0;
19        for (int i = 0; i < idx - 1; i++) {
20            res += Math.min(blocks[i], blocks[i + 1]);
21        }
22        
23        return res;
24    }
25}