// Last updated: 1/26/2026, 1:55:57 PM
1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] A) {
3        Arrays.sort(A);
4        int n = A.length;
5        int minDiff = Integer.MAX_VALUE;
6        List<List<Integer>> res = new ArrayList<>();
7
8        for (int i = 1; i < n; i++) {
9            int diff = A[i] - A[i - 1];
10            if (diff < minDiff) {
11                minDiff = diff;
12                res = new ArrayList<>();
13                res.add(Arrays.asList(A[i - 1], A[i]));
14            } else if (diff == minDiff) {
15                res.add(Arrays.asList(A[i - 1], A[i]));
16            }
17        }
18
19        return res;
20    }
21}
22