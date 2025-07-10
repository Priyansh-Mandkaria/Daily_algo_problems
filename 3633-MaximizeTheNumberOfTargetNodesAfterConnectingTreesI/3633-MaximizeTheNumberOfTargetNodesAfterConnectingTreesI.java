// Last updated: 7/10/2025, 8:50:19 AM
class Solution {
    private int getMaxNodes(List<List<Integer>> graph, int head, int k) {
        if(k < 0) return 0;
        int ans = 1;
        int n = graph.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(head);
        boolean vis[] = new boolean[n];
        vis[head] = true;
        while (q.size() > 0 && k-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                int top = q.poll();
                for(int next: graph.get(top)){
                    if(vis[next]) continue;
                    vis[next] = true;
                    q.add(next);
                }
            }
            ans += q.size();
        }
        return ans;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int max = 0;
        List<List<Integer>> graph2 = makeGraph(edges2);
        for(int i = 0;i<graph2.size();i++){
            int val = getMaxNodes(graph2, i, k - 1);
            max = Math.max(val, max);
        }
        List<List<Integer>> graph1 = makeGraph(edges1);
        int[] ans = new int[graph1.size()];
        for(int i = 0;i<graph1.size();i++){
            int val = getMaxNodes(graph1, i, k);
            ans[i] = val + max;
        }
        return ans;
    }

    private List<List<Integer>> makeGraph(int[][] edges){
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}