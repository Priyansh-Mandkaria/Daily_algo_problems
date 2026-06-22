// Last updated: 6/22/2026, 1:34:33 PM
class Solution {
    public int smallestAbsent(int[] a) {
        HashSet<Integer> st = new HashSet<>();
        long s = 0;
        for(int x : a){s += x; st.add(x);}
        int k = (int)(s/a.length)+1;
        if(k<1) k=1;
        while(st.contains(k))k++;
        return k;
    }
}