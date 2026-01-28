// Last updated: 1/28/2026, 6:04:10 AM
1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int n = grid.length, m = grid[0].length;
4        
5        // 1. Find the Maximum Value in the grid to size our helper arrays
6        int maxVal = 0;
7        for(int[] row : grid) {
8            for(int val : row) maxVal = Math.max(maxVal, val);
9        }
10
11        // dp[i][j] = Min cost to reach (n-1, m-1) from (i, j)
12        int[][] dp = new int[n][m];
13        
14        // temp[v] = Min cost starting from ANY cell with value 'v'
15        int[] temp = new int[maxVal + 1];
16        int[] best = new int[maxVal + 1];
17        
18        Arrays.fill(temp, Integer.MAX_VALUE);
19        
20        // Base Case: Cost from target to target is 0. 
21        // Note: The cost is incurred when ENTERING a cell. 
22        // We consider the target reached, so starting at target has 0 *additional* cost.
23        temp[grid[n - 1][m - 1]] = 0;
24
25        // --- INITIALIZATION (K=0) ---
26        // Fill DP table using standard walking rules (Right/Down)
27        for(int i = n - 1; i >= 0; i--) {
28            for(int j = m - 1; j >= 0; j--) {
29                if(i == n - 1 && j == m - 1) continue; // Skip target
30                
31                int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
32                int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
33                
34                dp[i][j] = Math.min(down, right);
35                
36                // Update the best known cost for this cell's value
37                if (dp[i][j] != Integer.MAX_VALUE) {
38                    temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
39                }
40            }
41        }
42
43        // --- LAYERS (K > 0) ---
44        // For each allowed teleport, we try to relax the grid costs
45        for(int x = 0; x < k; x++) {
46            
47            // 1. Build Prefix Minimum Array
48            // best[v] = min cost obtainable from any cell with value <= v
49            best[0] = temp[0];
50            for(int v = 1; v <= maxVal; v++) {
51                best[v] = Math.min(best[v - 1], temp[v]);
52            }
53            
54            // 2. Update DP Table with Teleport Options
55            for(int i = n - 1; i >= 0; i--) {
56                for(int j = m - 1; j >= 0; j--) {
57                    if(i == n - 1 && j == m - 1) continue;
58                    
59                    int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
60                    int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
61                    int walkCost = Math.min(down, right);
62                    
63                    // Teleport Option: Jump to the best state with value <= grid[i][j]
64                    int teleportCost = best[grid[i][j]];
65                    
66                    dp[i][j] = Math.min(walkCost, teleportCost);
67                    
68                    // Update temp for the NEXT iteration
69                    if (dp[i][j] != Integer.MAX_VALUE) {
70                        temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
71                    }
72                }
73            }
74        }
75        
76        return dp[0][0];
77    }
78}