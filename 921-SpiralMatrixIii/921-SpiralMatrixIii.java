// Last updated: 7/10/2025, 8:56:43 AM
class Solution {
    public int[][] spiralMatrixIII(int rows,int cols,int rStart,int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        int r = rStart, c = cStart, dirIdx = 0;
        int left = cStart, right = cStart, top = rStart, bottom = rStart;
        while (result.size() < rows * cols) {
            if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                result.add(new int[]{r, c});
                visited[r][c] = true;
            }
            r += directions[dirIdx][0];
            c += directions[dirIdx][1];
            if (dirIdx == 0 && c > right) { 
                dirIdx = 1;
                right++;
            } else if (dirIdx == 1 && r > bottom) { 
                dirIdx = 2; 
                bottom++;
            } else if (dirIdx == 2 && c < left) { 
                dirIdx = 3; 
                left--;
            } else if (dirIdx == 3 && r < top) { 
                dirIdx = 0;
                top--;
            }
        }
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}