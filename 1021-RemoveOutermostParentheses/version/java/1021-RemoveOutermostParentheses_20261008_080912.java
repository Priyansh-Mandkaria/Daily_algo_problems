// Last updated: 10/8/2026, 8:09:12 AM
1class Solution {
2    public String removeOuterParentheses(String s) {
3        int cnt = 0;
4        StringBuilder res = new StringBuilder();
5        for(int i = 0 ; i < s.length(); i++){
6            if(s.charAt(i) == '('){
7                if(cnt > 0) res.append(s.charAt(i));
8                cnt++;
9            }
10            else {
11                cnt--;
12                if(cnt > 0) res.append(s.charAt(i));
13            }
14        }
15        return res.toString();
16    }
17}