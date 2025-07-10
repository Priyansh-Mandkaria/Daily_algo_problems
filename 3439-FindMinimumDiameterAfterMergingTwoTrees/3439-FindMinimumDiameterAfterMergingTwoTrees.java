// Last updated: 7/10/2025, 8:51:08 AM
class Solution {
    private static final int N = 100000;
    private int[] deg = new int[N];
    private List<Integer>[] adj = new ArrayList[N];
    public int diameter(List<List<Integer>> edges) {
        int n = edges.size() + 1;
        Arrays.fill(deg, 0);
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> edge : edges) {
            int v = edge.get(0), w = edge.get(1);
            adj[v].add(w);
            adj[w].add(v);
            deg[v]++;
            deg[w]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) { 
                queue.offer(i);
            }
        }
        int level = 0, left = n;
        while (left > 2) { 
            int qSize = queue.size();
            left -= qSize;
            for (int i = 0; i < qSize; i++) {
                int v = queue.poll();
                for (int w : adj[v]) {
                    if (--deg[w] == 1) { 
                        queue.offer(w);
                    }
                }
            }
            level++;
        }
        return (left == 2) ? 2 * level + 1 : 2 * level;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> listEdges1 = convertToList(edges1);
        List<List<Integer>> listEdges2 = convertToList(edges2);
        int d1 = diameter(listEdges1);
        int d2 = diameter(listEdges2);
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }
    private List<List<Integer>> convertToList(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] edge : edges) {
            list.add(Arrays.asList(edge[0], edge[1]));
        }
        return list;
    }
}