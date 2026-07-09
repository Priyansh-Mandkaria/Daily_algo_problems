// Last updated: 7/9/2026, 10:07:21 AM
1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] q) {
3        boolean ans[] = new boolean[q.length]; 
4        int root[] = new int[nums.length]; 
5        root[0] = 0; 
6        for(int i = 1; i < nums.length; i++) {
7            root[i] = ((nums[i] - nums[i - 1]) <= maxDiff) ? root[i - 1] : i; 
8        }
9        for(int i = 0; i < q.length; i++) {
10            ans[i] = root[q[i][0]] == root[q[i][1]]; 
11        }
12        return ans; 
13    }
14}