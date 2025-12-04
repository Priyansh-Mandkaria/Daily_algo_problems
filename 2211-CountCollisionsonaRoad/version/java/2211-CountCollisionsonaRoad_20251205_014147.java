// Last updated: 12/5/2025, 1:41:47 AM
1class Solution {
2    public int countCollisions(String D) {
3        final int n=D.length();
4        if (n==1) return 0;
5        int l=0, r=n-1;
6        while (l<r && D.charAt(l)=='L') l++;
7        while (l<r && D.charAt(r)=='R') r--;
8        if (l>=r) return 0;
9        int col=0;
10        for( ; l<=r; l++){
11           col+=(D.charAt(l)!='S'?1:0);
12        }
13        return col;  
14    }
15}