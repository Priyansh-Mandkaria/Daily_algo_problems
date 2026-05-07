// Last updated: 5/7/2026, 12:34:34 PM
1class Solution {
2    public int[] maxValue(int[] arr) {
3        int n = arr.length;
4        int []p = bp(arr,n);
5        int []q = bs(arr,n);
6        return br(arr,p,q,n);
7    }
8    private int[] bp(int[] arr, int n){
9        int []p = new int[n];
10        p[0] = arr[0];
11        for(int i = 1; i < n; i++) p[i] = Math.max(p[i-1],arr[i]);
12        return p;
13    }
14    private int[] bs(int[] arr, int n){
15        int []q = new int[n];
16        q[n-1] = arr[n-1];
17        for(int i = n - 2; i >= 0 ; i--) q[i] = Math.min(q[i+1],arr[i]);
18        return q;
19    }
20    private int[] br(int[] arr, int[] p, int[] q, int n){
21        int []r = new int[n];
22        int s = 0;
23        int m = arr[0];
24        for(int i = 0 ; i < n - 1; i++){
25            m = Math.max(m,arr[i]);
26            if(p[i] <= q[i+1]){
27                assign(r,s,i,m);
28                s = i + 1;
29                if(s < n) m = arr[s];
30            }
31        }
32        assign(r,s,n-1,Math.max(m,arr[n-1]));
33        return r;
34    }
35    private void assign(int[] r, int l, int h, int v){
36        for(int i = l; i <= h; i++)r[i] = v;
37    }
38}