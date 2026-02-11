// Last updated: 2/11/2026, 1:38:46 PM
1class SegmentTree {
2    public int n, size;
3    public int[] sum, mn, mx;
4    SegmentTree(int n) {
5        this.n = n;
6        this.size = 4 * n;
7        this.sum = new int[size];
8        this.mn  = new int[size];
9        this.mx  = new int[size];
10    }
11    void pull(int node) {
12        int l = node * 2, r = node * 2 + 1;
13        sum[node] = sum[l] + sum[r];
14        mn[node] = Math.min(mn[l], sum[l] + mn[r]);
15        mx[node] = Math.max(mx[l], sum[l] + mx[r]);
16    }
17    void update(int idx, int val) {
18        int node = 1, l = 0, r = n - 1, index = 0;
19        int[] path = new int[32]; 
20        while (l != r) {
21            path[index++] = node;
22            int m = l + (r - l) / 2;
23            if (idx <= m) {
24                node = node * 2;
25                r = m;
26            } else {
27                node = node * 2 + 1;
28                l = m + 1;
29            }
30        }
31        sum[node] = val;
32        mn[node] = val;
33        mx[node] = val;
34        while (index > 0) {
35            pull(path[--index]);
36        }
37    }
38    int find_rightmost_prefix(int target) {
39        int node = 1, l = 0, r = n - 1, sum_before = 0;
40        if (target < mn[node] || target > mx[node]) return -1;
41        while (l != r) {
42            int m = l + (r - l) / 2;
43            int lchild = node * 2, rchild = node * 2 + 1;
44            int sum_before_right = sum[lchild] + sum_before;
45            int need_right = target - sum_before_right;
46            if (mn[rchild] <= need_right && need_right <= mx[rchild]) {
47                node = rchild;
48                l = m + 1;
49                sum_before = sum_before_right;
50            } else {
51                node = lchild;
52                r = m;
53            }
54        }
55        return l;
56    }
57}
58
59class Solution {
60    public int longestBalanced(int[] nums) {
61        int n = nums.length;
62        SegmentTree s_tree = new SegmentTree(n);
63        int[] first = new int[100001]; 
64        Arrays.fill(first, -1);
65        int result = 0;
66        for (int l = n - 1; l >= 0; --l) {
67            int num = nums[l];
68            if (first[num] != -1) {
69                s_tree.update(first[num], 0);
70            }
71            first[num] = l;
72            s_tree.update(l, (num & 1) == 0 ? 1 : -1);    
73            int r = s_tree.find_rightmost_prefix(0);
74            if (r >= l) {
75                result = Math.max(result, r - l + 1);
76            }
77        }
78        return result;
79    }
80}