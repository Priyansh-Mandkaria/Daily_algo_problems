// Last updated: 2/9/2026, 12:30:56 PM
1class Solution {
2    public void inorder(TreeNode node, List<Integer> vals) {
3        if (node == null) return;
4        inorder(node.left, vals);
5        vals.add(node.val);
6        inorder(node.right, vals);
7    }
8    public TreeNode build(List<Integer> vals, int l, int r) {
9        if (l > r) return null;
10        int mid = (l + r) / 2;
11        TreeNode node = new TreeNode(vals.get(mid));
12        node.left  = build(vals, l, mid - 1);
13        node.right = build(vals, mid + 1, r);
14        return node;
15    }
16    public TreeNode balanceBST(TreeNode root) {
17        List<Integer> vals = new ArrayList<>();
18        inorder(root, vals);
19        return build(vals, 0, vals.size() - 1);
20    }
21}