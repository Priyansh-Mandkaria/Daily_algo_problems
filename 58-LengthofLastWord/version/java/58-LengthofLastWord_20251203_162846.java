// Last updated: 12/3/2025, 4:28:46 PM
1class Solution {
2    public int lengthOfLastWord(String s) {
3        int i = s.length() - 1, len = 0;
4
5        while (i >= 0 && s.charAt(i) == ' ') i--;     // skip trailing spaces
6        while (i >= 0 && s.charAt(i) != ' ') {        // count last word
7            len++;
8            i--;
9        }
10        return len;
11    }
12}
13