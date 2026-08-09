// Last updated: 8/9/2026, 9:28:30 AM
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            int count = 0;

            for (int j = 0; j < points.length; j++) {

                int dx = points[j][0] - x;
                int dy = points[j][1] - y;

                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}