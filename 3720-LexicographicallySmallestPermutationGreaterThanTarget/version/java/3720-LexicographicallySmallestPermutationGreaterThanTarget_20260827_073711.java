// Last updated: 8/27/2026, 7:37:11 AM
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int n = s.length();
4        int[] freq = new int[26];
5        for (char ch : s.toCharArray()) {
6            freq[ch - 'a']++;
7        }
8        for (int i = 0; i < n; i++) {
9            freq[target.charAt(i) - 'a']--;
10        }
11        for (int i = n - 1; i >= 0; i--) {
12            int idx = target.charAt(i) - 'a';
13            freq[idx]++;
14            boolean valid = true;
15            for (int j = 0; j < 26; j++) {
16                if (freq[j] < 0) {
17                    valid = false;
18                    break;
19                }
20            }
21            if (!valid) {
22                continue;
23            }
24            for (int j = idx + 1; j < 26; j++) {
25                if (freq[j] > 0) {
26                    StringBuilder ans = new StringBuilder();
27                    ans.append(target, 0, i);
28                    ans.append((char) ('a' + j));
29                    freq[j]--;
30                    for (int k = 0; k < 26; k++) {
31                        while (freq[k] > 0) {
32                            ans.append((char) ('a' + k));
33                            freq[k]--;
34                        }
35                    }
36                    return ans.toString();
37                }
38            }
39        }
40        return "";
41    }
42}