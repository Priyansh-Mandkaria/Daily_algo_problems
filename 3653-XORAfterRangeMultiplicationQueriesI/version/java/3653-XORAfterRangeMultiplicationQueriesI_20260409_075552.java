// Last updated: 4/9/2026, 7:55:52 AM
1class Solution {
2    public int xorAfterQueries(int[] arr, int[][] q) {
3        int MOD = 1_000_000_007;
4        for(int[] qr : q){
5            for(int i = qr[0]; i <= qr[1]; i = i + qr[2]){
6                arr[i] = (int)(((long)arr[i]*qr[3])%MOD);
7            }
8        }
9        int ans = 0;
10        for(int x : arr) ans ^= x;
11        return ans;
12    }
13}