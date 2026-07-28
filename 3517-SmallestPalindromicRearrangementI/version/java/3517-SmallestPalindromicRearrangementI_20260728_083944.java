// Last updated: 7/28/2026, 8:39:44 AM
1class Solution {
2    public String smallestPalindrome(String s) {
3        int n = s.length();
4        char[] half = s.substring(0, n / 2).toCharArray();
5        Arrays.sort(half);
6        String res =
7            new String(half)
8            + ((n & 1) == 1 ? s.charAt(n / 2) : "")
9            + new StringBuilder(new String(half)).reverse();
10        return res;
11    }
12}