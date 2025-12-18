// Last updated: 12/18/2025, 5:24:51 PM
1class Solution {
2    public long maxProfit(int[] p, int[] s, int k) {
3        long res = 0;
4        long max = 0;
5        for(int i = 0 ; i < p.length; i++){
6            res += (long)p[i]*s[i];
7        }
8        long[] pp = new long[p.length+1];
9        long[] ps = new long[p.length+1];
10        for(int i = 0 ; i < p.length; i++){
11            pp[i+1] =  pp[i] + p[i];
12            ps[i+1] = ps[i] + (long)s[i] * p[i];
13        }
14        for(int i = 0; i <= p.length - k; i++ ){
15            long sp = pp[i + k] - pp[i + (k/2)];
16            long op = ps[i + k] - ps[i];
17            long g = sp-op;
18            max = Math.max(max,g); 
19        }
20        return res+max;
21    }
22}