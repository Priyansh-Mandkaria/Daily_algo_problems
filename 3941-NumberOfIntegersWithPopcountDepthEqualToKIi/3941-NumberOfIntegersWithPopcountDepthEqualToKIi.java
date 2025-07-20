// Last updated: 7/20/2025, 2:39:31 PM
class Solution {
    static class BIT {
        int[] t;
        BIT(int n) { t = new int[n + 2]; }
        void add(int i, int v) { for (++i; i < t.length; i += i & -i) t[i] += v; }
        int sum(int i) { int s = 0; for (++i; i > 0; i -= i & -i) s += t[i]; return s; }
        int get(int l, int r) { return l > r ? 0 : sum(r) - sum(l - 1); }
    }
    int dep(long x){
        int d = 0;
        while(x > 1){
            x = Long.bitCount(x);
            d++;
        }
        return d;
    }
    private BIT[] buildBITs(long[] arr, int[] dp, int mx, int n){
        BIT[] bit = new BIT[mx];
        for(int i = 0 ; i < mx; i++)bit[i] = new BIT(n);
        for(int i = 0; i < n; i++)bit[dp[i]].add(i,1);
        return bit;
        
    }
    private void upd(long[] arr, int[]dp, BIT[] bit, int i, long val){
        bit[dp[i]].add(i, -1);
        arr[i] = val;
        dp[i] = dep(val);
        bit[dp[i]].add(i, 1);
    }
    private int qry(BIT[]bit, int l, int r,int k , int mx){
        return k >= mx ? 0 : bit[k].get(l,r);
    }
    public int[] popcountDepth(long[] arr, long[][] qry) {
        int n = arr.length, mx = 6;
        int[] dp = Arrays.stream(arr).mapToInt(this::dep).toArray();
        BIT[] bit = buildBITs(arr, dp, mx, n);
        List<Integer> res = new ArrayList<>();
        for (long[] q : qry) {
            if (q[0] == 1)
                res.add(qry(bit, (int) q[1], (int) q[2], (int) q[3], mx));
            else
                upd(arr, dp, bit, (int) q[1], q[2]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}