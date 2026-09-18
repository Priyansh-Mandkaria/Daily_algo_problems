// Last updated: 9/18/2026, 9:29:52 AM
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4        int[] first = new int[26];
5        int[] last = new int[26];
6        Arrays.fill(first, n);
7        Arrays.fill(last, -1);
8        for (int i = 0; i < n; i++) {
9            int ch = s.charAt(i) - 'a';
10            if (first[ch] == n) {
11                first[ch] = i;
12            }
13            last[ch] = i;
14        }
15        List<int[]> intervals = new ArrayList<>();
16        for (int ch = 0; ch < 26; ch++) {
17            if (last[ch] == -1) {
18                continue;
19            }
20            int start = first[ch];
21            int end = last[ch];
22            boolean valid = true;
23            for (int i = start; i <= end; i++) {
24                int current = s.charAt(i) - 'a';
25                if (first[current] < start) {
26                    valid = false;
27                    break;
28                }
29                end = Math.max(end, last[current]);
30            }
31            if (valid) {
32                intervals.add(new int[]{start, end});
33            }
34        }
35        intervals.sort((a, b) -> {
36            if (a[1] != b[1]) {
37                return Integer.compare(a[1], b[1]);
38            }
39            return Integer.compare(a[1] - a[0], b[1] - b[0]);
40        });
41        List<String> answer = new ArrayList<>();
42        int previousEnd = -1;
43        for (int[] interval : intervals) {
44            int start = interval[0];
45            int end = interval[1];
46            if (start > previousEnd) {
47                answer.add(s.substring(start, end + 1));
48                previousEnd = end;
49            }
50        }
51        return answer;
52    }
53}