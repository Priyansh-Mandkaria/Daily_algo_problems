// Last updated: 2/8/2026, 8:35:56 AM
1class Solution {
2    int heightCheck(TreeNode root){
3        if(root==null) return 0;
4        int left = heightCheck(root.left);
5        int right = heightCheck(root.right);
6        if(left==-1 || right==-1) return -1;
7        if(Math.abs(left-right)>1) return -1;
8        return 1 + Math.max(left, right);
9    }
10    public boolean isBalanced(TreeNode root) {
11        int ans = heightCheck(root);
12        return ans==-1 ? false : true;
13    }
14}