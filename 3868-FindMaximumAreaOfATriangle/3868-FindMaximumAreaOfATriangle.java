// Last updated: 7/10/2025, 8:49:18 AM
class Solution {
    public long maxArea(int[][] points) {
        int n = points.length;
        if (n < 3) return -1;

        Map<Integer, List<Integer>> col = new HashMap<>();
        Map<Integer, List<Integer>> row = new HashMap<>();

        int lx = Integer.MAX_VALUE, rx = Integer.MIN_VALUE;
        int by = Integer.MAX_VALUE, ty = Integer.MIN_VALUE;

        for (int[] p : points) {
            int x = p[0], y = p[1];
            col.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
            row.computeIfAbsent(y, z -> new ArrayList<>()).add(x);
            lx = Math.min(lx, x);
            rx = Math.max(rx, x);
            by = Math.min(by, y);
            ty = Math.max(ty, y);
        }

        long best = Math.max(
            verticalCheck(col, lx, rx),
            horizontalCheck(row, by, ty)
        );

        return best > 0 ? best : -1;
    }

    private long verticalCheck(Map<Integer, List<Integer>> col, int lx, int rx) {
        long max = 0;
        for (int x : col.keySet()) {
            List<Integer> ys = col.get(x);
            if (ys.size() > 1) {
                Collections.sort(ys);
                long base = ys.get(ys.size() - 1) - ys.get(0);
                long height = Math.max(x - lx, rx - x);
                if (base > 0 && height > 0) {
                    max = Math.max(max, base * height);
                }
            }
        }
        return max;
    }

    private long horizontalCheck(Map<Integer, List<Integer>> row, int by, int ty) {
        long max = 0;
        for (int y : row.keySet()) {
            List<Integer> xs = row.get(y);
            if (xs.size() > 1) {
                Collections.sort(xs);
                long base = xs.get(xs.size() - 1) - xs.get(0);
                long height = Math.max(y - by, ty - y);
                if (base > 0 && height > 0) {
                    max = Math.max(max, base * height);
                }
            }
        }
        return max;
    }
}