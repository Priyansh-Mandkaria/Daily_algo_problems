// Last updated: 6/22/2026, 1:38:03 PM
class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        int ncx = coordinates[k][0], ncy = coordinates[k][1];
        int n = coordinates.length;

        // Sort coordinates by x and if equal, by decreasing y
        Arrays.sort(coordinates, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        List<Integer> coordinates1 = new ArrayList<>();
        List<Integer> coordinates2 = new ArrayList<>();

        // Classify points to the left & below and right & above (x_k, y_k)
        for (int i = 0; i < n; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if (x < ncx && y < ncy) {
                coordinates1.add(y);
            }
            if (x > ncx && y > ncy) {
                coordinates2.add(y);
            }
        }

        // Array to store intermediate LIS lengths
        int[] dp = new int[n];

        // Calculate LIS for both parts
        int size1 = calculateLIS(coordinates1, dp);
        int size2 = calculateLIS(coordinates2, dp);

        // Combine results
        return size1 + size2 + 1;
    }

    // Helper function to calculate LIS using binary search
    private int calculateLIS(List<Integer> coordinates, int[] dp) {
        int size = 0;

        for (int i = 0; i < coordinates.size(); i++) {
            int y = coordinates.get(i);

            // Binary search for the position in dp array
            int pos = Arrays.binarySearch(dp, 0, size, y);
            if (pos < 0) pos = -(pos + 1);

            dp[pos] = y;

            if (pos == size) size++;
        }

        return size;
    }
}