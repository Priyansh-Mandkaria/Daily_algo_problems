// Last updated: 9/27/2026, 9:41:48 AM
1class Solution { 
2    public String reverseParentheses(String s) { 
3        int n = s.length();
4        int[] pair = new int[n];
5        Deque<Integer> st = new ArrayDeque<>();
6        for (int i = 0; i < n; ++i) {
7            if (s.charAt(i) == '(') st.push(i);
8            else if (s.charAt(i) == ')') {
9                int j = st.pop();
10                pair[i] = j;
11                pair[j] = i;
12            }
13        }
14        StringBuilder res = new StringBuilder();
15        int i = 0, dir = 1;
16        while (i >= 0 && i < n) {
17            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
18                i = pair[i];
19                dir = -dir;
20            } else {
21                res.append(s.charAt(i));
22            }
23            i += dir;
24        }
25        return res.toString();
26    } 
27}