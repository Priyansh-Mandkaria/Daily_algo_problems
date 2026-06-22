// Last updated: 6/22/2026, 1:34:27 PM
class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        long[] px = new long[n + 1];
        long[] py = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char m = s.charAt(i);
            px[i + 1] = px[i];
            py[i + 1] = py[i];
            switch (m) {
                case 'L' -> px[i + 1]--;
                case 'R' -> px[i + 1]++;
                case 'D' -> py[i + 1]--;
                case 'U' -> py[i + 1]++;
            }
        }

        final long tx = px[n];
        final long ty = py[n];

        return IntStream.rangeClosed(0, n - k)
                .mapToObj(i -> {
                    long rx = px[i + k] - px[i];
                    long ry = py[i + k] - py[i];
                    return (tx - rx) + "," + (ty - ry);
                })
                .collect(Collectors.toSet())
                .size();
    }
}