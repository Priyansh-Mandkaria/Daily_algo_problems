// Last updated: 2/3/2026, 2:40:37 AM
1class Solution {
2
3    public long minimumCost(int[] nums, int k, int dist) {
4
5        int n = nums.length;
6        long result = Long.MAX_VALUE;
7        long windowSum = 0L;
8
9        java.util.TreeSet<Integer> using = new java.util.TreeSet<>(
10                (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
11        );
12
13        java.util.TreeSet<Integer> waiting = new java.util.TreeSet<>(
14                (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
15        );
16
17        for (int i = 1; i <= dist + 1; i++) {
18            using.add(i);
19            windowSum += nums[i];
20        }
21
22        while (using.size() > k - 1) {
23            int idx = using.pollLast();
24            windowSum -= nums[idx];
25            waiting.add(idx);
26        }
27
28        result = Math.min(result, windowSum);
29
30        for (int i = 1; i + dist + 1 < n; i++) {
31
32            waiting.add(i + dist + 1);
33
34            if (using.contains(i)) {
35                using.remove(i);
36                windowSum -= nums[i];
37
38                int idx = waiting.pollFirst();
39                using.add(idx);
40                windowSum += nums[idx];
41
42            } else {
43                waiting.remove(i);
44
45                int wMin = waiting.first();
46                int uMax = using.last();
47
48                if (nums[wMin] < nums[uMax]) {
49                    using.remove(uMax);
50                    waiting.add(uMax);
51                    windowSum -= nums[uMax];
52
53                    waiting.remove(wMin);
54                    using.add(wMin);
55                    windowSum += nums[wMin];
56                }
57            }
58
59            result = Math.min(result, windowSum);
60        }
61
62        return result + nums[0];
63    }
64}