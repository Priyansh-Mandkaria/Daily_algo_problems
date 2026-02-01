// Last updated: 2/1/2026, 1:20:38 PM
1class Solution {
2    public int minimumCost(int[] A) {
3        int a = 51, b = 51;
4        for (int i = 1; i < A.length; i++) {
5            if (A[i] < a) {
6                b = a;
7                a = A[i];
8            } else if (A[i] < b)
9                b = A[i];
10            if (a == 1 && b == 1) break;
11        }
12        return A[0] + a + b;
13    }
14}