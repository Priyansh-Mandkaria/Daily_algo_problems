// Last updated: 6/22/2026, 1:33:57 PM
class Solution {
    private int revnum(int a) {
        if (a / 10 == 0) return a ;
        StringBuilder s = new StringBuilder(Integer.toString(a)).reverse();
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') i++ ;
        return Integer.parseInt(s.substring(i));
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - revnum(n)) ;
    }
}