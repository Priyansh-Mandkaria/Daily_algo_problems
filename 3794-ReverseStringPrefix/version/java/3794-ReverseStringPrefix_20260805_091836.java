// Last updated: 8/5/2026, 9:18:36 AM
1class Solution {
2    public String reversePrefix(String s, int k) {
3        return new StringBuilder(s.substring(0,k)).reverse().toString()+s.substring(k);
4    }
5}