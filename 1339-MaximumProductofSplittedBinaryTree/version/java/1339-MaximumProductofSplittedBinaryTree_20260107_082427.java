// Last updated: 1/7/2026, 8:24:27 AM
1class Solution {
2  static long totalSum;
3  static long maxProduct;
4  static final int MOD = 1_000_000_007;
5
6  public int maxProduct(TreeNode root) {
7    maxProduct = 0;
8    totalSum = dfs(root);
9    dfsMaxProduct(root);
10    return (int) (maxProduct % MOD);
11  }
12
13  private long dfs(TreeNode node) {
14    if (node == null) return 0;
15    return node.val + dfs(node.left) + dfs(node.right);
16  }
17
18  private long dfsMaxProduct(TreeNode node) {
19    if (node == null) return 0;
20
21    long left = dfsMaxProduct(node.left);
22    long right = dfsMaxProduct(node.right);
23
24    long subtreeSum = node.val + left + right;
25    maxProduct = Math.max(maxProduct, subtreeSum * (totalSum - subtreeSum));
26
27    return subtreeSum;
28  }
29}