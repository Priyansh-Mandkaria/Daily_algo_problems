// Last updated: 4/30/2026, 3:38:35 PM
1class Solution {
2    int limit;
3    public int maxPathScore(int[][] grid, int k) {
4        limit=-2;
5        int m=grid.length,n=grid[0].length;
6        int[][][] dp=new int[m+1][n+1][Math.min(k+1,m+n+1)];
7        for(int[][] i:dp) for(int j[]:i) Arrays.fill(j,-1);
8        int ans=compute(0,0,0,grid,k,dp);
9        return ans==limit?-1:ans;
10    }
11    public int compute(int i,int j,int cost,int[][] grid,int k,int[][][] dp){
12        if(cost>k) return limit;
13        if(dp[i][j][cost]!=-1) return dp[i][j][cost];
14        if(i==grid.length-1&&j==grid[0].length-1){
15            if(grid[i][j]!=0) if(cost+1>k) return limit;
16            return grid[i][j];
17        }
18        if(i==grid.length||j==grid[0].length) return limit;
19        int ans=limit;
20        int toadd=(grid[i][j]!=0)?1:0;
21        ans=Math.max(ans,compute(i+1,j,cost+toadd,grid,k,dp));
22        ans=Math.max(ans,compute(i,j+1,cost+toadd,grid,k,dp));
23        return dp[i][j][cost]=(ans==limit?ans:ans+grid[i][j]);
24    }
25}