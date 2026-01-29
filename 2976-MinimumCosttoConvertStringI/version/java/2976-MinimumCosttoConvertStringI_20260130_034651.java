// Last updated: 1/30/2026, 3:46:51 AM
1class Solution {
2    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
3        int INF = Integer.MAX_VALUE / 2;
4        int[][] dist = new int[26][26];
5
6        for (int i = 0; i < 26; i++) {
7            Arrays.fill(dist[i], INF);
8            dist[i][i] = 0;
9        }
10
11        for (int i = 0; i < original.length; i++) {
12            int u = original[i] - 'a';
13            int v = changed[i] - 'a';
14
15            dist[u][v] = Math.min(dist[u][v], cost[i]);
16        }
17
18        for (int k = 0; k < 26; k++) {
19            for (int i = 0; i < 26; i++) {
20                for (int j = 0; j < 26; j++) {
21                    if (dist[i][k] < INF && dist[k][j] < INF) {
22                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
23                    }
24                }
25            }
26        }
27
28        long total_cost = 0;
29        for (int i = 0; i < source.length(); i++) {
30            int s = source.charAt(i) - 'a';
31            int t = target.charAt(i) - 'a';
32            if (s == t) continue;
33            if (dist[s][t] == INF) return -1;
34            total_cost += dist[s][t];
35        }
36
37        return total_cost;
38    }
39}