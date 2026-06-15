// Last updated: 6/15/2026, 10:00:19 PM
1class Solution {
2    private static final String[] MAP = {
3        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
4    };
5    private void fun(String digits, int ptr, StringBuilder curr, List<String> res) {
6        if(ptr == digits.length()) {
7            res.add(curr.toString()); 
8            return;
9        }
10        int len = curr.length(); 
11        String poss = MAP[digits.charAt(ptr) - '2']; 
12        for(int i = 0; i < poss.length(); i++){
13            curr.append(poss.charAt(i));
14            fun(digits, ptr + 1, curr, res); 
15            curr.setLength(len); 
16        }
17    }
18    public List<String> letterCombinations(String digits) {
19        List<String> res = new ArrayList<>();
20        if (digits == null || digits.length() == 0) return res;
21        fun(digits, 0, new StringBuilder(), res);
22        return res;
23    }
24}