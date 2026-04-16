// Last updated: 4/16/2026, 1:54:11 PM
1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
7        }
8        List<Integer> ans = new ArrayList<>();
9        for (int q : queries) {
10            List<Integer> v = map.get(nums[q]);
11            if (v.size() == 1) {
12                ans.add(-1);
13                continue;
14            }
15            int pos = Collections.binarySearch(v, q);
16            int res = Integer.MAX_VALUE;
17            int left = v.get((pos - 1 + v.size()) % v.size());
18            int d1 = Math.abs(q - left);
19            res = Math.min(res, Math.min(d1, n - d1));
20            int right = v.get((pos + 1) % v.size());
21            int d2 = Math.abs(q - right);
22            res = Math.min(res, Math.min(d2, n - d2));
23            ans.add(res);
24        }
25        return ans;
26    }
27}