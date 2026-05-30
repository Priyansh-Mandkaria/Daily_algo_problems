// Last updated: 5/30/2026, 9:14:37 AM
1class Solution {
2
3    private final int MAXX = 50000;
4    private int[] seg;
5
6    private void update(int node, int l, int r, int idx, int val) {
7        if (l == r) {
8            seg[node] = val;
9            return;
10        }
11
12        int mid = (l + r) / 2;
13
14        if (idx <= mid)
15            update(2 * node, l, mid, idx, val);
16        else
17            update(2 * node + 1, mid + 1, r, idx, val);
18
19        seg[node] = Math.max(seg[2 * node], seg[2 * node + 1]);
20    }
21
22    private int query(int node, int l, int r, int ql, int qr) {
23        if (ql > r || qr < l)
24            return 0;
25
26        if (ql <= l && r <= qr)
27            return seg[node];
28
29        int mid = (l + r) / 2;
30
31        return Math.max(
32            query(2 * node, l, mid, ql, qr),
33            query(2 * node + 1, mid + 1, r, ql, qr)
34        );
35    }
36
37    public List<Boolean> getResults(int[][] queries) {
38
39        seg = new int[4 * (MAXX + 1)];
40
41        TreeSet<Integer> obstacles = new TreeSet<>();
42        obstacles.add(0);
43
44        for (int[] q : queries) {
45            if (q[0] == 1) obstacles.add(q[1]);
46        }
47
48        List<Integer> pos = new ArrayList<>(obstacles);
49
50        for (int i = 1; i < pos.size(); i++) {
51            update(1,0,MAXX,pos.get(i),pos.get(i) - pos.get(i - 1));
52        }
53
54        List<Boolean> ans = new ArrayList<>();
55
56        for (int i = queries.length - 1; i >= 0; i--) {
57
58            if (queries[i][0] == 2) {
59
60                int x = queries[i][1];
61                int sz = queries[i][2];
62
63                int prevObstacle = obstacles.floor(x);
64
65                int best = query(1, 0,MAXX,0,prevObstacle);
66                best = Math.max(best, x - prevObstacle);
67
68                ans.add(best >= sz);
69            }
70            else {
71
72                int x = queries[i][1];
73
74                Integer leftPos = obstacles.lower(x);
75
76                update(1,0,MAXX,x,0);
77
78                Integer rightPos = obstacles.higher(x);
79
80                if (rightPos != null) {
81                    update(1,0,MAXX,rightPos,rightPos - leftPos);
82                }
83
84                obstacles.remove(x);
85            }
86        }
87
88        Collections.reverse(ans);
89        return ans;
90    }
91}