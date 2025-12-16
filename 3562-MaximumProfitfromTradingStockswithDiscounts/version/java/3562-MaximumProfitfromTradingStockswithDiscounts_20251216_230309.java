// Last updated: 12/16/2025, 11:03:09 PM
1class Solution {
2    private List<Integer>[] children;
3    private int[] parent, present, future;
4    private int budget;
5    
6    private void createHierarchy(int n, int[][] hierarchy) {
7        children = new ArrayList[n + 1];
8        parent = new int[n + 1];
9        
10        for (int i = 1; i <= n; i++) {
11            children[i] = new ArrayList<>();
12        }
13        
14        for (int[] relation : hierarchy) {
15            int boss = relation[0];
16            int subordinate = relation[1];
17            children[boss].add(subordinate);
18            parent[subordinate] = boss;
19        }
20        
21        parent[1] = 0;
22    }
23    
24    private int[] combine(int[] dp1, int[] dp2) {
25        int[] newDp = new int[budget + 1];
26        for (int b1 = 0; b1 <= budget; b1++) {
27            for (int b2 = 0; b1 + b2 <= budget; b2++) {
28                newDp[b1 + b2] = Math.max(newDp[b1 + b2], dp1[b1] + dp2[b2]);
29            }
30        }
31        return newDp;
32    }
33    
34    private int[][] dfs(int employee) {
35        int costWithoutDiscount = present[employee - 1];
36        int profitWithoutDiscount = future[employee - 1] - costWithoutDiscount;
37        int costWithDiscount = present[employee - 1] / 2;
38        int profitWithDiscount = future[employee - 1] - costWithDiscount;
39        
40        int[] dpChildrenNo = new int[budget + 1]; 
41        int[] dpChildrenYes = new int[budget + 1]; 
42        
43        dpChildrenNo[0] = 0;
44        dpChildrenYes[0] = 0;
45        
46        List<int[][]> childResults = new ArrayList<>();
47        for (int child : children[employee]) {
48            childResults.add(dfs(child));
49        }
50        
51        for (int[][] childRes : childResults) {
52            int[] childNoDiscount = childRes[0];
53            int[] childWithDiscount = childRes[1];
54            
55            dpChildrenNo = combine(dpChildrenNo, childNoDiscount);
56            dpChildrenYes = combine(dpChildrenYes, childWithDiscount);
57        }
58        
59        int[] dpNoDiscount = new int[budget + 1];
60        for (int b = 0; b <= budget; b++) {
61            dpNoDiscount[b] = dpChildrenNo[b];
62        }
63
64        for (int b = costWithoutDiscount; b <= budget; b++) {
65            int newProfit = dpChildrenYes[b - costWithoutDiscount] + profitWithoutDiscount;
66            if (newProfit > dpNoDiscount[b]) {
67                dpNoDiscount[b] = newProfit;
68            }
69        }
70        
71        int[] dpWithDiscount = new int[budget + 1];
72        for (int b = 0; b <= budget; b++) {
73            dpWithDiscount[b] = dpChildrenNo[b];
74        }
75
76        for (int b = costWithDiscount; b <= budget; b++) {
77            int newProfit = dpChildrenYes[b - costWithDiscount] + profitWithDiscount;
78            if (newProfit > dpWithDiscount[b]) {
79                dpWithDiscount[b] = newProfit;
80            }
81        }
82        
83        return new int[][]{dpNoDiscount, dpWithDiscount};
84    }
85    
86    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
87        this.present = present;
88        this.future = future;
89        this.budget = budget;
90        
91        createHierarchy(n, hierarchy);
92        
93        int[][] result = dfs(1);
94        
95        int maxProfit = 0;
96        for (int b = 0; b <= budget; b++) {
97            maxProfit = Math.max(maxProfit, result[0][b]);
98        }
99        
100        return maxProfit;
101    }
102}