// Last updated: 4/22/2026, 5:43:31 AM
1class Solution {
2    private int diff(String a, String b) {
3        int n = a.length();
4        int same = 0;
5        for(int i = 0; i < n; i++) {
6            if(a.charAt(i) == b.charAt(i)){
7                same++;
8            }
9        }
10        int count = n -same;
11        return count;
12    }
13   
14	public List<String> twoEditWords(String[] queries, String[] dictionary) {
15		List<String> ans = new ArrayList<>();
16		for (String query : queries) {
17			for (String word : dictionary) {
18				int diff = diff(query, word);
19				if (diff <= 2) {
20					ans.add(query);
21					break;
22				}
23			}
24		}
25		return ans;
26	}
27}