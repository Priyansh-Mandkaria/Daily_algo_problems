// Last updated: 7/29/2026, 8:36:29 AM
1class Solution {
2    public String smallestPalindrome(String s, int k) {
3        int n = s.length();
4        int[] count = new int[26];
5        for (char c : s.toCharArray()) count[c - 'a']++;
6        int oddIdx = -1;
7        for (int i = 0; i < 26; i++) {
8            if (count[i] % 2 != 0) oddIdx = i;
9        }
10        int[] half = new int[26];
11        int halfLen = 0;
12        for (int i = 0; i < 26; i++) {
13            half[i] = count[i] / 2;
14            halfLen += half[i];
15        }
16        long Top = 3_000_000_000L;
17        long total = countArrangements(half, halfLen, Top);
18        if (total < k) return "";
19        StringBuilder sb = new StringBuilder();
20        long remainingK = k;
21        int remaining = halfLen;
22        for (int pos = 0; pos < halfLen; pos++) {
23            for (int c = 0; c < 26; c++) {
24                if (half[c] == 0) continue;
25                half[c]--; 
26                long arrangements = countArrangements(half, remaining - 1, Top);
27                if (remainingK <= arrangements) {
28                    sb.append((char) ('a' + c));
29                    break; 
30                } else {
31                    remainingK -= arrangements; 
32                    half[c]++; 
33                }
34            }
35            remaining--;
36        }
37        String halfStr = sb.toString();
38        StringBuilder full = new StringBuilder(halfStr);
39        if (oddIdx != -1) full.append((char) ('a' + oddIdx));
40        full.append(new StringBuilder(halfStr).reverse());
41        return full.toString();
42    }
43    public long countArrangements(int[] cnt, int total, long Top) {
44        long result = 1;
45        int remaining = total;
46        for (int i = 0; i < 26 && result <= Top; i++) {
47            int c = cnt[i];
48            long comb = 1;
49            for (int j = 1; j <= c; j++) {
50                comb = comb * (remaining - c + j) / j; 
51                if (comb > Top) { comb = Top + 1; break; }
52            }
53            result *= comb;
54            if (result > Top) { result = Top + 1; break; }
55            remaining -= c;
56        }
57        return result;
58    }
59}