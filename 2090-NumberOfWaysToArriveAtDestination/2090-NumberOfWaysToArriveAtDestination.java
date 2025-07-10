// Last updated: 7/10/2025, 8:54:05 AM
class Pair{
   long first;
    int second;
    Pair(long _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            if (u >= n || v >= n) continue;  
            adj.get(u).add(new Pair(w, v)); 
            adj.get(v).add(new Pair(w, u));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingLong(x -> x.first));
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0); 
        dist[0]=0;
        ways[0]=1;
        q.add(new Pair(0,0));
        int mod=(int)(1e9+7);
        while(!q.isEmpty()){
            long dis=q.peek().first;
            int node=q.peek().second;
            q.remove();
                        if (dis > dist[node]) continue;
            for(Pair it:adj.get(node)){
                int adjNode=it.second;
                long edW=it.first;

                if(dis+edW<dist[adjNode]){
                    dist[adjNode]=dis+edW;
                    q.add(new Pair(dis+edW,adjNode));
                    ways[adjNode]=ways[node];
                }
                else if(dis+edW==dist[adjNode]){
                    ways[adjNode]=(ways[node]+ways[adjNode])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}
