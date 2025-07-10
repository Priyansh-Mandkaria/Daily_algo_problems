// Last updated: 7/10/2025, 8:49:28 AM
class Solution {
    public int reverseDegree(String s) {
        int rev = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i)
            rev += ((26 - (s.charAt(i) - 'a')) * (i + 1));
        return rev;
    }
}