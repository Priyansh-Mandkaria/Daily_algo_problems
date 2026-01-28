// Last updated: 1/28/2026, 6:04:47 AM
1class Solution {
2    public int minCost(int n, int[][] e) {
3        List<int[]>[] g  = new List[n];
4        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
5        for(int[] x : e){
6            g[x[0]].add(new int[]{x[1],x[2]});
7            g[x[1]].add(new int[]{x[0],x[2]*2});
8        }
9        long[] d = new long[n];
10        Arrays.fill(d,Long.MAX_VALUE);
11        d[0] = 0;
12        PriorityQueue<long[]>pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
13        pq.add(new long[]{0,0});
14        while(!pq.isEmpty()){
15            long[] c = pq.poll();
16            long t = c[0];
17            int u = (int)c[1];
18            if(t > d[u]) continue;
19            if(u == n-1) break;
20            for(int[] nx : g[u]){
21                int v = nx[0];
22                long w = nx[1];
23                if(d[u] + w < d[v]){
24                    d[v] = d[u] + w;
25                    pq.add(new long[]{d[v],v});
26                }
27            }
28        }
29        return d[n-1] == Long.MAX_VALUE ? -1 : (int)d[n-1];
30    }
31}