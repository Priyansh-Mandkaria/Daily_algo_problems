// Last updated: 6/28/2026, 8:59:56 AM
1class Solution {
2    private static final int[] freq = new int[100005];
3    public int maximumElementAfterDecrementingAndRearranging(int[] A) {
4        int n = A.length;
5        for (int x : A)
6            freq[Math.min(x, n)]++;
7        int res = 1;
8        for (int i = 2; i <= n; i++)
9            res = Math.min(res + freq[i], i);
10        for (int i = 0; i <= n; i++)
11            freq[i] = 0;
12        return res;
13    }
14}