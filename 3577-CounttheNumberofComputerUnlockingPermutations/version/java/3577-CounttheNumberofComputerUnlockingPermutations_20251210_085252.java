// Last updated: 12/10/2025, 8:52:52 AM
1class Solution {
2    public int countPermutations(int[] complexity) {
3        int mod = 1000000007;
4        long ans = 1;
5        for(int i = 1; i < complexity.length; i++) {
6            if(complexity[i] <= complexity[0]) return 0;
7            else ans = (ans * i) % mod;
8        }
9        return (int)ans;
10    }
11}