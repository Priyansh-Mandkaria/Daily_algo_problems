// Last updated: 7/10/2025, 8:56:42 AM
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
    private int[] a;
    private int[] b;
    private int[] c;
    
    public TreeNode constructFromPrePost(int[] a1, int[] a2) {
        a = a1;
        b = a2;
        int a3 = 0;
        for (int a4 : b) a3 = Math.max(a3, a4);
        c = new int[a3 + 1];
        for (int a5 = 0; a5 < b.length; a5++) c[b[a5]] = a5;
        return a6(0, a.length - 1, 0, b.length - 1);
    }
    
    private TreeNode a6(int a7, int a8, int a9, int a10) {
        if(a7 > a8) return null;
        TreeNode a11 = new TreeNode(a[a7]);
        if(a7 == a8) return a11;
        int a12 = a[a7 + 1];
        int a13 = c[a12];
        int a14 = a13 - a9 + 1;
        a11.left = a6(a7 + 1, a7 + a14, a9, a13);
        a11.right = a6(a7 + a14 + 1, a8, a13 + 1, a10 - 1);
        return a11;
    }
}