// Last updated: 7/10/2025, 8:56:58 AM
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int it : graph[i]) {
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int a = q.poll();
            ans.add(a);
            for (int it : adj.get(a)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}