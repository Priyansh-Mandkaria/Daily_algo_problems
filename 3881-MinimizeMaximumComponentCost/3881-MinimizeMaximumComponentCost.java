// Last updated: 7/13/2025, 12:58:41 PM
class Solution {
    public static class tuf{
        int[] parent,rank;
        int comp;
        tuf(int n){
            parent = new int[n];
            rank = new int[n];
            comp = n;
            for(int i = 0 ; i < n ; i++) parent[i] = i;
        }
        int fin(int x){
            return parent[x] == x ? x : (parent[x] = fin(parent[x]));
        }
        void union(int x , int y){
            int rx = fin(x),ry = fin(y);
            if(rx != ry){
                if(rank[rx]<rank[ry])parent[rx] =ry;
                else{
                    parent[ry] = rx;
                    if(rank[rx] == rank[ry])rank[rx]++;
                }
                comp--;
            }
        }
    }
    public int minCost(int n, int[][] arr, int k) {
        if(n <= k) return 0;
        Arrays.sort(arr,Comparator.comparingInt(a -> a[2]));
        tuf d = new tuf(n);
        for(int[]e :arr){
            d.union(e[0],e[1]);
            if(d.comp <= k)return e[2];
        }
        return -1;
    }
}