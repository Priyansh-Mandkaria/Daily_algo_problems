// Last updated: 1/7/2026, 12:39:51 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int maxLevelSum(TreeNode root) {
18        Queue<TreeNode> q = new LinkedList<>();
19        q.add(root);
20        int max = Integer.MIN_VALUE;
21        int ans = 1;
22        int curr = 1;
23        while (!q.isEmpty()) {
24            int c = 0;
25            int size = q.size();
26            for (int i = 0; i < size; i++) {
27                TreeNode temp = q.remove();
28                c += temp.val;
29                if (temp.left != null)
30                    q.add(temp.left);
31                if (temp.right != null) 
32                    q.add(temp.right);
33            }    
34            if (c > max) {
35                max = c;
36                ans = curr;
37            }
38            curr += 1;
39        }
40        return ans;
41    }
42}