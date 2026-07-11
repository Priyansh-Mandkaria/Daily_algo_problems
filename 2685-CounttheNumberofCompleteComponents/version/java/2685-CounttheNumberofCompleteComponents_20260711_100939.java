// Last updated: 7/11/2026, 10:09:39 AM
1class Solution {
2    private Map<Integer, List<Integer>> graph = new HashMap<>();
3    public int countCompleteComponents(int n, int[][] edges) {
4        for (int[] edge : edges) {
5            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
6            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
7        }
8        Set<Integer> visited = new HashSet<>();
9        int count = 0;
10        for (int i = 0; i < n; i++) {
11            if (!visited.contains(i)) {
12                Set<Integer> component = new HashSet<>();
13                dfs(i, component, visited);
14                if (isCompleteComponent(component)) count++;
15            }
16        }
17        return count;
18    }
19    private void dfs(int node, Set<Integer> component, Set<Integer> visited) {
20        component.add(node);
21        visited.add(node);
22        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
23            if (!visited.contains(neighbor)) {
24                dfs(neighbor, component, visited);
25            }
26        }
27    }
28    private boolean isCompleteComponent(Set<Integer> component) {
29        for (int node : component) {
30            if (graph.getOrDefault(node, new ArrayList<>()).size() != component.size() - 1) {
31                return false;
32            }
33        }
34        return true;
35    }
36}