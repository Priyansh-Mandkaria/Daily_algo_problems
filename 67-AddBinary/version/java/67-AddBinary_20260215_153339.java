// Last updated: 2/15/2026, 3:33:39 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        int n1 = a.length(), n2 = b.length();
4        int max = Math.max(n1, n2);
5        int C = 0, i = 0;
6        StringBuilder sb = new StringBuilder();
7        while (i < max || C > 0) {
8            int A = i < n1 ? a.charAt(n1 - 1 - i) - '0' : 0;
9            int B = i < n2 ? b.charAt(n2 - 1 - i) - '0' : 0;
10            int S = (A ^ B) ^ C;
11            int C_out = ((A ^ B) & C) | (A & B);
12            sb.append((char)(S + '0'));
13            C = C_out;
14            i++;
15        }
16        return sb.reverse().toString();
17    }
18}
19