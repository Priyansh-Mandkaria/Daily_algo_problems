// Last updated: 7/10/2025, 8:49:22 AM
class Solution {
    int N, LOG = 17;
    int[][] p;
    long[] dist;
    int[] dep;
    ArrayList<int[]>[] g;

    void dfs(int u, int par, int depth, long d) {
        p[u][0] = par; dep[u] = depth; dist[u] = d;
        for (var e : g[u]) {
            int v = e[0], w = e[1];
            if (v != par) dfs(v, u, depth + 1, d + w);
        }
    }

    void build() {
        for (int j = 1; j < LOG; j++)
            for (int i = 0; i < N; i++)
                p[i][j] = p[i][j - 1] == -1 ? -1 : p[p[i][j - 1]][j - 1];
    }

    int lca(int a, int b) {
        if (dep[a] < dep[b]) { int t = a; a = b; b = t; }
        int diff = dep[a] - dep[b];
        for (int i = 0; i < LOG; i++) if (((diff >> i) & 1) == 1) a = p[a][i];
        if (a == b) return a;
        for (int i = LOG - 1; i >= 0; i--)
            if (p[a][i] != -1 && p[a][i] != p[b][i]) {
                a = p[a][i]; b = p[b][i];
            }
        return p[a][0];
    }

    long dist(int a, int b) {
        int l = lca(a, b);
        return dist[a] + dist[b] - 2 * dist[l];
    }

    public int[] minimumWeight(int[][] edges, int[][] queries) {
        N = edges.length + 1;
        g = new ArrayList[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        p = new int[N][LOG];
        for (int[] row : p) Arrays.fill(row, -1);
        dist = new long[N]; dep = new int[N];
        dfs(0, -1, 0, 0L);
        build();

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s1 = queries[i][0], s2 = queries[i][1], t = queries[i][2];
            long res = (dist(s1, s2) + dist(s2, t) + dist(t, s1)) / 2;
            ans[i] = (int) res;
        }
        return ans;
    }
}