// Last updated: 6/27/2026, 12:54:02 PM
1class Solution {
2    public int maximumLength(int[] nums) {
3        Map<Long, Integer> count = new HashMap<>();
4        for (int x : nums) {
5            long key = x;
6            count.put(key, count.getOrDefault(key, 0) + 1);
7        }
8        int res = 0;
9        for (long start : count.keySet()) {
10            long key = start;
11            int total = 0;
12            if (key == 1) {
13                int freq = count.get(key);
14                total = freq % 2 == 1 ? freq : freq - 1;
15            } else {
16                while (count.getOrDefault(key, 0) >= 2 && count.containsKey(key * key)) {
17                    total += 2;
18                    key = key * key;
19                }
20                total += 1;
21            }
22            res = Math.max(res, total);
23        }
24        return res;
25    }
26}