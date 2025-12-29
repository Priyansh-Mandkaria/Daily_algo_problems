// Last updated: 12/30/2025, 4:20:40 AM
1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4        StringBuilder res = new StringBuilder();
5        for(int i = words.length-1; i >= 0; i--){
6            res.append(words[i]);
7            if(i > 0) res.append(" ");// so that no extra will add like in trailing 
8        }
9        return res.toString();
10    }
11}