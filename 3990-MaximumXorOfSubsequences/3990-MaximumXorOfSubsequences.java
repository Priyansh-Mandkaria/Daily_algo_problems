// Last updated: 6/22/2026, 1:34:54 PM
class Solution {
    public int maxXorSubsequences(int[] a) {
        List<Integer> b = new ArrayList<>();
        for (int v : a) { int t=v; for (int x:b) t=Math.min(t,t^x); if(t!=0)b.add(t); }
        return b.stream().reduce(0,(r,x)->Math.max(r,r^x));
    }
}