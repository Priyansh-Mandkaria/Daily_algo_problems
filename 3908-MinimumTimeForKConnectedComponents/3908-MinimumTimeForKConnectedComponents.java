// Last updated: 7/10/2025, 8:49:07 AM
class Solution {
    public int minTime(int n, int[][] edges, int k) {
        if (n == 0) return 0;
        if (edges.length == 0) {
            return 0;
        }
        int maxTime = 0;
        for (int[] edge : edges) {
            maxTime = Math.max(maxTime, edge[2]);
        }
        int low = 0;
        int high = maxTime + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int comp = countComponents(n, edges, mid);
            if (comp >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int countComponents(int n, int[][] edges, int t) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (edge[2] > t) {
                dsu.union(edge[0], edge[1]);
            }
        }
        return dsu.count;
    }
    static class DSU {
        int[] parent;
        int[] rank;
        int count;
        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else if (rank[rx] > rank[ry]) {
                parent[ry] = rx;
            } else {
                parent[ry] = rx;
                rank[rx]++;
            }
            count--;
        }
    }
}