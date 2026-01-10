// Last updated: 1/10/2026, 2:43:12 PM
1class Solution {
2    public TreeNode subtreeWithAllDeepest(TreeNode root) {
3        if (root == null) return null;
4
5        Map<TreeNode, TreeNode> parent = new HashMap<>();
6        Queue<TreeNode> q = new LinkedList<>();
7        q.offer(root);
8        parent.put(root, null);
9
10        List<TreeNode> lastLevel = new ArrayList<>();
11
12        // BFS traversal
13        while (!q.isEmpty()) {
14            int size = q.size();
15            lastLevel.clear();
16
17            for (int i = 0; i < size; i++) {
18                TreeNode node = q.poll();
19                lastLevel.add(node);
20
21                if (node.left != null) {
22                    parent.put(node.left, node);
23                    q.offer(node.left);
24                }
25                if (node.right != null) {
26                    parent.put(node.right, node);
27                    q.offer(node.right);
28                }
29            }
30        }
31
32        Set<TreeNode> deepest = new HashSet<>(lastLevel);
33
34        // Move upward until all nodes converge
35        while (deepest.size() > 1) {
36            Set<TreeNode> next = new HashSet<>();
37            for (TreeNode node : deepest) {
38                next.add(parent.get(node));
39            }
40            deepest = next;
41        }
42
43        return deepest.iterator().next();
44    }
45}