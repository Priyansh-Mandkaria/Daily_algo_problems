// Last updated: 9/25/2026, 10:43:05 AM
1class Solution {
2    TreeSet<String> ans = new TreeSet<>();
3    void dfs(String s) {
4        int r = s.indexOf('}');
5        if (r == -1) {
6            ans.add(s);
7            return;
8        }
9        int l = s.lastIndexOf('{', r);
10        String left = s.substring(0, l);
11        String right = s.substring(r + 1);
12        String inside = s.substring(l + 1, r);
13        for (String part : inside.split(",")) {
14            dfs(left + part + right);
15        }
16    }
17    public List<String> braceExpansionII(String expression) {
18        dfs(expression);
19        return new ArrayList<>(ans);
20    }
21}