// Last updated: 7/3/2026, 9:33:16 AM
class Solution {
    class Pair {
        long cost;
        int node;
        Pair(long cost, int node) {
            this.cost = cost;
            this.node = node;
        }
    }

    public boolean dijkstra(int minCost, int n, long k, Map<Integer, List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        pq.offer(new Pair(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            long cost = top.cost;
            int node = top.node;

            if (cost > dist[node]) continue;

            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int v = neighbor[0];
                int vCost = neighbor[1];
                if (vCost >= minCost && dist[v] > cost + vCost) {
                    dist[v] = cost + vCost;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }

        return dist[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            if (online[u] && online[v]) {
                adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
            }
        }

        int n = online.length;
        long ans = -1;
        long l = 0, r = Integer.MAX_VALUE;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (dijkstra((int)mid, n, k, adj)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (int) ans;
    }
}