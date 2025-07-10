// Last updated: 7/10/2025, 8:51:52 AM
class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        long totalSum = 0;
        for (int value : values) totalSum += value;
        if (totalSum % k != 0) return 1;
        boolean[] visited = new boolean[n];
        int[] result = new int[1];
        dfs(0, -1, tree, values, k, visited, result);
        return result[0];
    }
    private long dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, boolean[] visited, int[] result) {
        visited[node] = true;
        long subtreeSum = values[node];
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent && !visited[neighbor]) {
                subtreeSum += dfs(neighbor, node, tree, values, k, visited, result);
            }
        }
        if (subtreeSum % k == 0) {
            result[0]++; 
            return 0;    
        }
        return subtreeSum;
    }
}