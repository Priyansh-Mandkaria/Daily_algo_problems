// Last updated: 6/15/2026, 10:09:57 PM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> res = new ArrayList<String>();
4        recurse(res, 0, 0, "", n);
5        return res;
6    }
7    public void recurse(List<String> res, int left, int right, String s, int n) {
8        if (s.length() == n * 2) {
9            res.add(s);
10            return;
11        }
12        if (left < n) {
13            recurse(res, left + 1, right, s + "(", n);
14        }
15        if (right < left) {
16            recurse(res, left, right + 1, s + ")", n);
17        }
18    }
19}