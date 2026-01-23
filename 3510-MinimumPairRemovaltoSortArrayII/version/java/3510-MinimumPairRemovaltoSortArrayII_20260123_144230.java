// Last updated: 1/23/2026, 2:42:30 PM
1class Solution {
2
3  private static class Segment implements Comparable<Segment> {
4      int index;
5      long value;
6      long mergeCost;
7      Segment left;
8      Segment right;
9
10      Segment(int idx, long val) {
11          index = idx;
12          value = val;
13      }
14
15      @Override
16      public int compareTo(Segment o) {
17          if (right == null || o.right == null) {
18              return right == null ? 1 : -1;
19          }
20          long diff = mergeCost - o.mergeCost;
21          if (diff != 0) return diff < 0 ? -1 : 1;
22          return index - o.index;
23      }
24  }
25
26  public int minimumPairRemoval(int[] nums) {
27      TreeSet<Segment> heap = new TreeSet<>();
28      int violations = 0;
29
30      Segment current = null;
31
32      for (int i = 0; i < nums.length; i++) {
33          Segment node = new Segment(i, nums[i]);
34
35          if (current != null) {
36              if (node.value < current.value) violations++;
37
38              current.right = node;
39              node.left = current;
40
41              current.mergeCost = current.value + node.value;
42              heap.add(current);
43          }
44          current = node;
45      }
46
47      heap.add(current);
48
49      int operations = 0;
50
51      while (violations > 0) {
52          operations++;
53
54          Segment best = heap.pollFirst();
55          Segment next = best.right;
56
57          if (next.value < best.value) violations--;
58
59          best.value += next.value;
60          best.mergeCost = best.value + (next.right != null ? next.right.value : 0);
61
62          best.right = next.right;
63          if (next.right != null) {
64              if (next.right.value < next.value) violations--;
65              next.right.left = best;
66              if (best.value > next.right.value) violations++;
67          }
68
69          heap.remove(next);
70          heap.add(best);
71
72          Segment prev = best.left;
73          if (prev != null) {
74              heap.remove(prev);
75
76              if (prev.value > prev.mergeCost - prev.value) violations--;
77              if (prev.value > best.value) violations++;
78
79              prev.mergeCost = prev.value + best.value;
80              prev.right = best;
81
82              heap.add(prev);
83          }
84      }
85
86      return operations;
87  }
88}