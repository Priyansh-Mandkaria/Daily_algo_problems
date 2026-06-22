// Last updated: 6/22/2026, 1:34:22 PM
class Solution {
    public int longestSubsequence(int[] a) {
        int n=a.length, x=Arrays.stream(a).reduce(0,(p,q)->p^q);
        return x!=0?n:(Arrays.stream(a).anyMatch(v->v!=0)?n-1:0);
    }
}