// Last updated: 11/28/2025, 4:48:33 PM
1class Solution {
2    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
3        List<List<Integer>> tree = new ArrayList<>();
4        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
5        for (int[] edge : edges) {
6            tree.get(edge[0]).add(edge[1]);
7            tree.get(edge[1]).add(edge[0]);
8        }
9        long totalSum = 0;
10        for (int value : values) totalSum += value;
11        if (totalSum % k != 0) return 1;
12        boolean[] visited = new boolean[n];
13        int[] result = new int[1];
14        dfs(0, -1, tree, values, k, visited, result);
15        return result[0];
16    }
17    private long dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, boolean[] visited, int[] result) {
18        visited[node] = true;
19        long subtreeSum = values[node];
20        for (int neighbor : tree.get(node)) {
21            if (neighbor != parent && !visited[neighbor]) {
22                subtreeSum += dfs(neighbor, node, tree, values, k, visited, result);
23            }
24        }
25        if (subtreeSum % k == 0) {
26            result[0]++; 
27            return 0;    
28        }
29        return subtreeSum;
30    }
31}