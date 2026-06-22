// Last updated: 6/22/2026, 1:35:04 PM
class Solution {
    public long maxProfit(int[] p, int[] s, int k) {
        long res = 0;
        long max = 0;
        for(int i = 0 ; i < p.length; i++){
            res += (long)p[i]*s[i];
        }
        long[] pp = new long[p.length+1];
        long[] ps = new long[p.length+1];
        for(int i = 0 ; i < p.length; i++){
            pp[i+1] =  pp[i] + p[i];
            ps[i+1] = ps[i] + (long)s[i] * p[i];
        }
        for(int i = 0; i <= p.length - k; i++ ){
            long sp = pp[i + k] - pp[i + (k/2)];
            long op = ps[i + k] - ps[i];
            long g = sp-op;
            max = Math.max(max,g); 
        }
        return res+max;
    }
}