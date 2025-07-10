// Last updated: 7/10/2025, 8:52:42 AM
class Solution {
    int[] dirX = { 0, 0, 1, -1 };
    int[] dirY = { 1, -1, 0, 0 };
    record Cell(int row, int col, int val) {}
    record Query(int idx, int val) {}

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, total = m * n;
        Query[] sortedQueries = new Query[queries.length];
        for (int i = 0; i < queries.length; i++) 
            sortedQueries[i] = new Query(i, queries[i]);
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a.val, b.val));
        
        Cell[] sortedCells = new Cell[total];
        for (int row = 0; row < m; row++) 
            for (int col = 0; col < n; col++) 
                sortedCells[row * n + col] = new Cell(row, col, grid[row][col]);
        Arrays.sort(sortedCells, (a, b) -> Integer.compare(a.val, b.val));

        UnionFind uf = new UnionFind(total);
        int[] res = new int[queries.length];
        int idx = 0;

        for (Query q : sortedQueries) {
            while (idx < total && sortedCells[idx].val < q.val) {
                int row = sortedCells[idx].row, col = sortedCells[idx].col, id = row * n + col;
                for (int d = 0; d < 4; d++) {
                    int newRow = row + dirX[d], newCol = col + dirY[d];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] < q.val) 
                        uf.union(id, newRow * n + newCol);
                }
                idx++;
            }
            res[q.idx] = q.val > grid[0][0] ? uf.getSize(0) : 0;
        }
        return res;
    }
}
class UnionFind {
    private final int[] parent, size;
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
    }
    public int find(int x) {
        return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
    }
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        return true;
    }
    public int getSize(int x) {
        return size[find(x)];
    }
}
