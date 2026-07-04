// Last updated: 7/4/2026, 6:52:55 AM
1class Solution {
2    private int[] parent;
3    private int[] minEdge;
4    public int minScore(int n, int[][] roads) {
5        parent = new int[n+1];
6        minEdge = new int[n+1];
7        for (int i=0; i<=n; ++i) {
8            parent[i] = i;
9            minEdge[i] = Integer.MAX_VALUE;
10        }
11        for (int[] road : roads) {
12            union(road[0], road[1], road[2]);
13        }
14        return minEdge[find(1)];
15    }
16    private int find(int x) {
17        while (parent[x] != x) {
18            parent[x] = parent[parent[x]];
19            x = parent[x];
20        }
21        return x;
22    }
23    private void union(int a, int b, int d) {
24        int parentA = find(a);
25        int parentB = find(b);
26        if (parentA != parentB) {
27            parent[parentA] = parentB;
28            minEdge[parentB] = Math.min(minEdge[parentB], Math.min(minEdge[parentA], d));
29        } else {
30            minEdge[parentA] = Math.min(minEdge[parentA], d);
31        }
32    }
33}