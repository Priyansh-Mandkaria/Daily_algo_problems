// Last updated: 1/16/2026, 5:20:49 PM
1import java.util.*;
2
3class Solution {
4    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
5        List<Integer> hList = new ArrayList<>();
6        for (int h : hFences) hList.add(h);
7        hList.add(1);
8        hList.add(m);
9
10        List<Integer> vList = new ArrayList<>();
11        for (int v : vFences) vList.add(v);
12        vList.add(1);
13        vList.add(n);
14
15        Set<Integer> stt = new HashSet<>();
16        long ans = 0;
17
18        for (int i = 0; i < hList.size(); i++) {
19            for (int j = i + 1; j < hList.size(); j++) {
20                stt.add(Math.abs(hList.get(j) - hList.get(i)));
21            }
22        }
23
24        for (int i = 0; i < vList.size(); i++) {
25            for (int j = i + 1; j < vList.size(); j++) {
26                int val = Math.abs(vList.get(j) - vList.get(i));
27                if (stt.contains(val)) {
28                    ans = Math.max(ans, val);
29                }
30            }
31        }
32
33        if (ans == 0) {
34            return -1;
35        }
36
37        long MOD = 1_000_000_007;
38        return (int) ((ans * ans) % MOD);
39    }
40}