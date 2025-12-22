// Last updated: 12/22/2025, 4:32:36 PM
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        // compare both string in their sorted format - most thinkable approach
4        char ch[] = s.toCharArray();
5        char chh[] = t.toCharArray();
6        Arrays.sort(ch);
7        Arrays.sort(chh);
8        return Arrays.equals(ch,chh);
9    }
10}