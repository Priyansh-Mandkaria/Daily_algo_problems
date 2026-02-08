// Last updated: 2/8/2026, 8:35:15 AM
1class Solution {
2
3    int heightCheck(TreeNode root){
4        if(root==null) return 0;
5
6        int left = heightCheck(root.left);
7        int right = heightCheck(root.right);
8        
9        if(left==-1 || right==-1) return -1;
10
11        if(Math.abs(left-right)>1) return -1;
12
13        return 1 + Math.max(left, right);
14    }
15
16    public boolean isBalanced(TreeNode root) {
17        int ans = heightCheck(root);
18
19        return ans==-1 ? false : true;
20    }
21}