// Last updated: 7/20/2025, 2:39:49 PM
class Solution {
    public int countIslands(int[][] arr, int k) {
        int r = arr.length;
        int c = arr[0].length;
        boolean[][] dir = new boolean[r][c];
        int z = (int)java.util.stream.IntStream.range(0,r).mapToObj(a-> java.util.stream.IntStream.range(0,c).filter(b-> arr[a][b] > 0 && !dir[a][b] && dfs(a,b,arr,dir,r,c) % k == 0).count()).mapToLong(Long::longValue).sum();
        return z;
    }
    private long dfs(int a , int b , int[][] arr, boolean[][] dir, int r , int c){
        if(a < 0 || a >= r || b < 0 || b >= c || dir[a][b] || arr[a][b] == 0) return 0;
        dir[a][b] = true;
        return arr[a][b] + dfs(a+1,b,arr,dir,r,c) + dfs(a-1,b,arr,dir,r,c)+ dfs(a,b+1,arr,dir,r,c) + dfs(a,b-1,arr,dir,r,c);
    }
}