// Last updated: 6/22/2026, 1:35:02 PM
class Solution {
    public int[] maxValue(int[] arr) {
        int n = arr.length;
        int []p = bp(arr,n);
        int []q = bs(arr,n);
        return br(arr,p,q,n);
    }
    private int[] bp(int[] arr, int n){
        int []p = new int[n];
        p[0] = arr[0];
        for(int i = 1; i < n; i++) p[i] = Math.max(p[i-1],arr[i]);
        return p;
    }
    private int[] bs(int[] arr, int n){
        int []q = new int[n];
        q[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0 ; i--) q[i] = Math.min(q[i+1],arr[i]);
        return q;
    }
    private int[] br(int[] arr, int[] p, int[] q, int n){
        int []r = new int[n];
        int s = 0;
        int m = arr[0];
        for(int i = 0 ; i < n - 1; i++){
            m = Math.max(m,arr[i]);
            if(p[i] <= q[i+1]){
                assign(r,s,i,m);
                s = i + 1;
                if(s < n) m = arr[s];
            }
        }
        assign(r,s,n-1,Math.max(m,arr[n-1]));
        return r;
    }
    private void assign(int[] r, int l, int h, int v){
        for(int i = l; i <= h; i++)r[i] = v;
    }
}