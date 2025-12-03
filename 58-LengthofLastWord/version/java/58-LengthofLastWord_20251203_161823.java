// Last updated: 12/3/2025, 4:18:23 PM
1class Solution {
2    public int lengthOfLastWord(String s) {
3        String[] parts = s.trim().split(" ");
4        return parts[parts.length - 1].length();
5    }
6}
7