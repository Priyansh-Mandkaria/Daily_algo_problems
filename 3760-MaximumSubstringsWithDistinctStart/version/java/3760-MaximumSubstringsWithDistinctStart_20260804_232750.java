// Last updated: 8/4/2026, 11:27:50 PM
1class Solution {
2    public int maxDistinct(String s) {
3        HashSet<Character> set = new HashSet<>();
4        for(char x : s.toCharArray()){
5            set.add(x);
6        }
7        return set.size();
8    }
9}