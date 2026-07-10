// Last updated: 7/10/2026, 9:32:52 AM
1class Solution {
2    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        int m = queries.length, l = 1;
4        int[] ans = new int[m];
5        long[] sorted = new long[n];
6        for(int i = 0; i < n; i++) sorted[i] = (long)nums[i] << 32 | i;
7        Arrays.sort(sorted);
8        for(int i = 1; i < n; i <<= 1) l++;
9        int[][] jumps = new int[l][n];
10        int[] rank = new int[n];
11        int right = 0;
12        for(int i = 0; i < n; i++) {
13            rank[(int)sorted[i]] = i;
14            while(right < n && (sorted[right] >>> 32) <= (sorted[i] >>> 32) + maxDiff) right++;
15            jumps[0][i] = right - 1;
16        }
17        for(int i = 1; i < l; i++) {
18            for(int j = 0; j < n; j++) jumps[i][j] = jumps[i - 1][jumps[i - 1][j]];
19        }
20        for(int i = 0; i < m; i++) {
21            int a = rank[queries[i][0]], b = rank[queries[i][1]];
22            if(a > b) {
23                int temp = a;
24                a = b;
25                b = temp;
26            }
27            ans[i] = jumps[l - 1][a] < b ? -1 : calcJumps(jumps, a, b, l);
28        }
29        return ans;
30    }
31    private int calcJumps(int[][] jumps, int a, int b, int right) {
32        if(a == b) return 0;
33        if(jumps[0][a] >= b) return 1;
34        int left = 0;
35        while(left < right) {
36            int mid = left + right + 1 >>> 1;
37            if(jumps[mid][a] < b) left = mid;
38            else right = mid - 1;
39        }
40        return (1 << left) + calcJumps(jumps, jumps[left][a], b, left);
41    }
42}