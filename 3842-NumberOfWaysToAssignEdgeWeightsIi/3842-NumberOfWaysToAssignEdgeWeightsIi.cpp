// Last updated: 6/22/2026, 1:36:24 PM
class Solution {
public:
    static constexpr int MOD = 1000000007;

    vector<int> assignEdgeWeights(vector<vector<int>>& edges,
                                  vector<vector<int>>& queries) {
        int n = edges.size() + 1;

        vector<vector<int>> adj(n + 1);
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        int LOG = 17;
        while ((1 << LOG) <= n)
            LOG++;

        vector<int> depth(n + 1, 0);
        vector<vector<int>> up(LOG, vector<int>(n + 1, 0));

        function<void(int, int)> dfs = [&](int u, int p) {
            up[0][u] = p;
            for (int v : adj[u]) {
                if (v == p)
                    continue;
                depth[v] = depth[u] + 1;
                dfs(v, u);
            }
        };

        dfs(1, 0);

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                up[k][v] = up[k - 1][v] ? up[k - 1][up[k - 1][v]] : 0;
            }
        }

        auto lca = [&](int a, int b) {
            if (depth[a] < depth[b])
                swap(a, b);

            int diff = depth[a] - depth[b];
            for (int k = 0; k < LOG; k++) {
                if (diff & (1 << k)) {
                    a = up[k][a];
                }
            }

            if (a == b)
                return a;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][a] != up[k][b]) {
                    a = up[k][a];
                    b = up[k][b];
                }
            }

            return up[0][a];
        };

        vector<long long> pow2(n + 1, 1);
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        vector<int> ans;
        ans.reserve(queries.size());

        for (auto& q : queries) {
            int u = q[0], v = q[1];

            int w = lca(u, v);
            int dist =
                depth[u] + depth[v] - 2 * depth[w]; // number of edges on path

            if (dist == 0) {
                ans.push_back(0);
            } else {
                ans.push_back((int)pow2[dist - 1]);
            }
        }

        return ans;
    }
};