// Last updated: 9/12/2026, 7:56:05 AM
1import java.util.*;
2class Solution {
3    static class State implements Comparable<State> {
4        long score;
5        List<Integer> indices;
6        State(long score, List<Integer> indices) {
7            this.score = score;
8            this.indices = indices;
9        }
10        public int compareTo(State other) {
11            if (this.score != other.score)
12                return Long.compare(this.score, other.score);
13            int len = Math.min(this.indices.size(), other.indices.size());
14            for (int i = 0; i < len; i++) {
15                int cmp = Integer.compare(this.indices.get(i), other.indices.get(i));
16                if (cmp != 0) return cmp;
17            }
18            return Integer.compare(this.indices.size(), other.indices.size());
19        }
20    }
21    public int[] maximumWeight(List<List<Integer>> a) {
22        Map<String, Integer> originalIndex = new LinkedHashMap<>();
23        for (int i = 0; i < a.size(); i++) {
24            List<Integer> iv = a.get(i);
25            String key = iv.get(0) + "," + iv.get(1) + "," + iv.get(2);
26            if (!originalIndex.containsKey(key)) {
27                originalIndex.put(key, i);
28            }
29        }
30        List<int[]> withIndex = new ArrayList<>();
31        for (Map.Entry<String, Integer> e : originalIndex.entrySet()) {
32            String[] parts = e.getKey().split(",");
33            withIndex.add(new int[]{
34                Integer.parseInt(parts[0]),
35                Integer.parseInt(parts[1]),
36                Integer.parseInt(parts[2]),
37                e.getValue()
38            });
39        }
40        withIndex.sort((x, y) -> {
41            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
42            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
43            return Integer.compare(x[2], y[2]);
44        });
45        int n = withIndex.size();
46        int[][] intervals = new int[n][3];
47        int[] origIdx = new int[n];
48        for (int i = 0; i < n; i++) {
49            intervals[i][0] = withIndex.get(i)[0];
50            intervals[i][1] = withIndex.get(i)[1];
51            intervals[i][2] = withIndex.get(i)[2];
52            origIdx[i] = withIndex.get(i)[3];
53        }
54        int[] nextIndex = new int[n];
55        for (int i = 0; i < n; i++) {
56            int right = intervals[i][1];
57            int lo = 0, hi = n;
58            while (lo < hi) {
59                int mid = (lo + hi) / 2;
60                if (intervals[mid][0] > right) hi = mid;
61                else lo = mid + 1;
62            }
63            nextIndex[i] = lo;
64        }
65        State[][] dp = new State[n + 1][5];
66        for (int k = 0; k <= 4; k++)
67            dp[n][k] = new State(0, new ArrayList<>());
68        for (int i = n - 1; i >= 0; i--) {
69            dp[i][0] = new State(0, new ArrayList<>());
70            int weight = intervals[i][2];
71            for (int k = 1; k <= 4; k++) {
72                State skip = dp[i + 1][k];
73                State takeNext = dp[nextIndex[i]][k - 1];
74                long takeScore = takeNext.score - weight;
75                List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
76                takeIndices.add(origIdx[i]);
77                Collections.sort(takeIndices);
78                State take = new State(takeScore, takeIndices);
79                dp[i][k] = (skip.compareTo(take) <= 0) ? skip : take;
80            }
81        }
82        List<Integer> resultList = dp[0][4].indices;
83        int[] result = new int[resultList.size()];
84        for (int i = 0; i < result.length; i++) result[i] = resultList.get(i);
85        return result;
86    }
87}