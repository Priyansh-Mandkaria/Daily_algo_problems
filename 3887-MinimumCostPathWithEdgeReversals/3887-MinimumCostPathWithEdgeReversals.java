// Last updated: 6/22/2026, 1:35:57 PM
class Solution {
    public int minCost(int n, int[][] e) {
        List<int[]>[] g  = new List[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for(int[] x : e){
            g[x[0]].add(new int[]{x[1],x[2]});
            g[x[1]].add(new int[]{x[0],x[2]*2});
        }
        long[] d = new long[n];
        Arrays.fill(d,Long.MAX_VALUE);
        d[0] = 0;
        PriorityQueue<long[]>pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] c = pq.poll();
            long t = c[0];
            int u = (int)c[1];
            if(t > d[u]) continue;
            if(u == n-1) break;
            for(int[] nx : g[u]){
                int v = nx[0];
                long w = nx[1];
                if(d[u] + w < d[v]){
                    d[v] = d[u] + w;
                    pq.add(new long[]{d[v],v});
                }
            }
        }
        return d[n-1] == Long.MAX_VALUE ? -1 : (int)d[n-1];
    }
}