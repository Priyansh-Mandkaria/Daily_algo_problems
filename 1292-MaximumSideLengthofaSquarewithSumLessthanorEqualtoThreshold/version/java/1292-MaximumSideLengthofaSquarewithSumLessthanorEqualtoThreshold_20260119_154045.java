// Last updated: 1/19/2026, 3:40:45 PM
1class Solution {
2
3    private boolean isValid(int[][] pref, int k, int limit) {
4        int n = pref.length;
5        int m = pref[0].length;
6
7        for (int i = k - 1; i < n; i++) {
8            for (int j = k - 1; j < m; j++) {
9                int x1 = i - k + 1;
10                int y1 = j - k + 1;
11
12                int sum = pref[i][j];
13                if (x1 > 0) sum -= pref[x1 - 1][j];
14                if (y1 > 0) sum -= pref[i][y1 - 1];
15                if (x1 > 0 && y1 > 0) sum += pref[x1 - 1][y1 - 1];
16
17                if (sum <= limit)
18                    return true;
19            }
20        }
21        return false;
22    }
23
24    public int maxSideLength(int[][] mat, int threshold) {
25        int n = mat.length;
26        int m = mat[0].length;
27
28        int[][] pref = new int[n][m];
29
30        // Copy matrix
31        for (int i = 0; i < n; i++)
32            System.arraycopy(mat[i], 0, pref[i], 0, m);
33
34        // Row-wise prefix sum
35        for (int i = 0; i < n; i++)
36            for (int j = 1; j < m; j++)
37                pref[i][j] += pref[i][j - 1];
38
39        // Column-wise prefix sum
40        for (int j = 0; j < m; j++)
41            for (int i = 1; i < n; i++)
42                pref[i][j] += pref[i - 1][j];
43
44        int low = 1, high = Math.min(n, m);
45        int ans = 0;
46
47        while (low <= high) {
48            int mid = (low + high) / 2;
49            if (isValid(pref, mid, threshold)) {
50                ans = mid;
51                low = mid + 1;
52            } else {
53                high = mid - 1;
54            }
55        }
56
57        return ans;
58    }
59}