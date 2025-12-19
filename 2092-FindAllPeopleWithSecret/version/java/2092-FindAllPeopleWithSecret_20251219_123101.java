// Last updated: 12/19/2025, 12:31:01 PM
1class Solution {
2    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
3        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
4
5        int[] parent = new int[n];
6        boolean[] know = new boolean[n];
7        for (int i = 0; i < n; i++) parent[i] = i;
8
9        know[0] = know[firstPerson] = true;
10
11        for (int i = 0; i < meetings.length; ) {
12            int t = meetings[i][2];
13            List<Integer> list = new ArrayList<>();
14
15            int j = i;
16            while (j < meetings.length && meetings[j][2] == t) {
17                union(meetings[j][0], meetings[j][1], parent);
18                list.add(meetings[j][0]);
19                list.add(meetings[j][1]);
20                j++;
21            }
22
23            for (int p : list)
24                if (know[p])
25                    know[find(p, parent)] = true;
26
27            for (int p : list)
28                know[p] |= know[find(p, parent)];
29
30            for (int p : list)
31                parent[p] = p;
32
33            i = j;
34        }
35
36        List<Integer> res = new ArrayList<>();
37        for (int i = 0; i < n; i++)
38            if (know[i]) res.add(i);
39        return res;
40    }
41
42    private int find(int x, int[] p) {
43        return p[x] == x ? x : (p[x] = find(p[x], p));
44    }
45
46    private void union(int a, int b, int[] p) {
47        int pa = find(a, p), pb = find(b, p);
48        if (pa != pb) p[pb] = pa;
49    }
50}