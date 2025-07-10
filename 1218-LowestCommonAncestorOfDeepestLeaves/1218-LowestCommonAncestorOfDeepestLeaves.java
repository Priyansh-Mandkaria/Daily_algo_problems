// Last updated: 7/10/2025, 8:56:09 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int lval=help(root.left);
        int rval=help(root.right);
        if(lval==rval){
            return root;
        }
        else if(lval>rval){
            return lcaDeepestLeaves(root.left);
        }
        else{
            return lcaDeepestLeaves(root.right);
        }
    }
    public int help(TreeNode root){
        if(root==null){
            return -1;
        }
        return Math.max(help(root.left),help(root.right))+1;
    }
}