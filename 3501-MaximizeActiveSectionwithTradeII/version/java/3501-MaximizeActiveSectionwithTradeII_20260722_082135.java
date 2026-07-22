// Last updated: 7/22/2026, 8:21:35 AM
1import java.util.regex.*;
2class Solution {
3    private int[] zs, ze, V;
4    private int nblocks;
5    private List<int[]> sparse;
6    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
7        int ones = (int) s.chars().filter(c -> c == '1').count();
8        List<Integer> zsL = new ArrayList<>(), zeL = new ArrayList<>();
9        Matcher mo = Pattern.compile("0+").matcher(s);
10        while (mo.find()) { zsL.add(mo.start()); zeL.add(mo.end() - 1); }
11        zs = zsL.stream().mapToInt(Integer::intValue).toArray();
12        ze = zeL.stream().mapToInt(Integer::intValue).toArray();
13        nblocks = zs.length;
14        V = IntStream.range(0, nblocks - 1)
15                     .map(j -> (ze[j] - zs[j] + 1) + (ze[j + 1] - zs[j + 1] + 1))
16                     .toArray();
17        int nv = V.length;
18        sparse = new ArrayList<>();
19        sparse.add(V);
20        for (int half = 1; half * 2 <= nv; half *= 2) {
21            int[] prev = sparse.get(sparse.size() - 1);
22            int[] next = new int[prev.length - half];
23            for (int i = 0; i < next.length; i++)
24                next[i] = Math.max(prev[i], prev[i + half]);
25            sparse.add(next);
26        }
27        List<Integer> ans = new ArrayList<>(queries.length);
28        for (int[] q : queries) ans.add(ones + gain(q[0], q[1]));
29        return ans;
30    }
31    private int rmq(int lo, int hi) { 
32        int t = 31 - Integer.numberOfLeadingZeros(hi - lo + 1);
33        return Math.max(sparse.get(t)[lo], sparse.get(t)[hi - (1 << t) + 1]);
34    }
35    private int clip(int j, int l, int r) {
36        return V[j] - Math.max(0, l - zs[j]) - Math.max(0, ze[j + 1] - r);
37    }
38    private int gain(int l, int r) {
39        if (nblocks < 2) return 0;
40        int ja = lowerBound(ze, l);
41        int jb = upperBound(zs, r) - 2;               
42        if (ja > jb) return 0;
43        return Math.max(Math.max(clip(ja, l, r), clip(jb, l, r)),
44                        jb - ja >= 2 ? rmq(ja + 1, jb - 1) : 0);
45    }
46    private static int lowerBound(int[] a, int x) {
47        int lo = 0, hi = a.length;
48        while (lo < hi) { int mid = (lo + hi) >>> 1; if (a[mid] < x) lo = mid + 1; else hi = mid; }
49        return lo;
50    }
51    private static int upperBound(int[] a, int x) {
52        int lo = 0, hi = a.length;
53        while (lo < hi) { int mid = (lo + hi) >>> 1; if (a[mid] <= x) lo = mid + 1; else hi = mid; }
54        return lo;
55    }
56}