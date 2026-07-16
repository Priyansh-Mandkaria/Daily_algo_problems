// Last updated: 7/16/2026, 11:31:47 AM
1class Solution {
2    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
3    public long gcdSum(int[] A) {
4        int max = 0;
5        for (int i = 0; i < A.length; i++) {
6            max = Math.max(max, A[i]);
7            A[i] = gcd(A[i], max);
8        }
9        Arrays.sort(A);
10        long res = 0;        
11        for (int i = 0, j = A.length - 1; i < j; i++, j--)
12            res += gcd(A[i], A[j]);
13        return res;
14    }
15}