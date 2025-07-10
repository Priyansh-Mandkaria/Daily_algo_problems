// Last updated: 7/10/2025, 8:54:19 AM
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        char[] clrs = colors.toCharArray();
        int n = clrs.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int[] edg : edges) {
            int u = edg[0];
            int v = edg[1];
            graph[u].add(v);
            inDegree[v]++;
        }
        int[] queue = new int[n];
        int head = -1, tail = -1;
        int visited = 0;
        for (int u = 0; u < n; u++) {
            if (inDegree[u] == 0) {
                queue[++tail] = u;
                visited++;
            }
        }
        int[][] dp = new int[n][26];
        int res = 0;
        while (head < tail) {
            int u = queue[++head];
            int color = clrs[u] - 'a';
            dp[u][color]++;
            res = Math.max(res, dp[u][color]);
            for (int v : graph[u]) {
                for (int clr = 0; clr < 26; clr++) {
                    dp[v][clr] = Math.max(dp[v][clr], dp[u][clr]);
                }
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue[++tail] = v;
                    visited++;
                }
            }
        }
        return visited == n ? res : -1;
    }
}