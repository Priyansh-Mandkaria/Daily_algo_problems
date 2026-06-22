// Last updated: 6/22/2026, 1:36:33 PM
class Solution {

    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] rMax = new int[n + 1];
        int[] rMin = new int[n + 1];
        int[] cMax = new int[n + 1];
        int[] cMin = new int[n + 1];

        Arrays.fill(rMin, n + 1);
        Arrays.fill(cMin, n + 1);

        for (int[] p : buildings) {
            int x = p[0], y = p[1];

            rMax[y] = Math.max(rMax[y], x);
            rMin[y] = Math.min(rMin[y], x);

            cMax[x] = Math.max(cMax[x], y);
            cMin[x] = Math.min(cMin[x], y);
        }

        int cnt = 0;

        for (int[] p : buildings) {
            int x = p[0], y = p[1];

            if (x > rMin[y] && x < rMax[y] &&
                y > cMin[x] && y < cMax[x]) 
            {
                cnt++;
            }
        }

        return cnt;
    }
}