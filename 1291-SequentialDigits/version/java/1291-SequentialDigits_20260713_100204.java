// Last updated: 7/13/2026, 10:02:04 AM
1class Solution {
2    static final int[] q = new int[45];
3    static {
4        int n = 0;
5        for (int i = 1; i < 10; i++)
6            q[n++] = i;
7        for (int i = 0; i < n; i++) {
8            int d = q[i] % 10;
9            if (d < 9) 
10                q[n++] = q[i] * 10 + d + 1;
11        }
12    }
13    public List<Integer> sequentialDigits(int low, int high) {
14        List<Integer> res = new ArrayList<>();
15        for (int x : q)
16            if (x >= low && x <= high)
17                res.add(x);
18        return res;
19    }
20}