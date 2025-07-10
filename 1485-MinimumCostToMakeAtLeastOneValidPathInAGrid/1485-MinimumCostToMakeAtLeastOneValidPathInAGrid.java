// Last updated: 7/10/2025, 8:55:35 AM
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        cost[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + directions[dir][0];
                int ny = y + directions[dir][1];
                int newCost = cost[x][y] + (grid[x][y] == dir + 1 ? 0 : 1);
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    if (grid[x][y] == dir + 1) {
                        deque.offerFirst(new int[]{nx, ny}); 
                    } else {
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}