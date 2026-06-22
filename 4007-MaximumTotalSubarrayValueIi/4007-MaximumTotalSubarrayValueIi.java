// Last updated: 6/22/2026, 1:34:39 PM
import java.util.*;

class Solution {

    static class SparseTable {
        int n, K;
        int[][] stMin, stMax;
        int[] logTable;
        int[] arr;

        SparseTable(int[] a) {
            arr = a;
            n = a.length;
            K = (int)(Math.log(n) / Math.log(2)) + 1;

            stMin = new int[K][n];
            stMax = new int[K][n];
            logTable = new int[n + 1];

            logTable[1] = 0;
            for (int i = 2; i <= n; i++) {
                logTable[i] = logTable[i / 2] + 1;
            }

            build();
        }

        void build() {
            for (int i = 0; i < n; i++) {
                stMin[0][i] = i;
                stMax[0][i] = i;
            }

            for (int k = 1; k < K; k++) {
                for (int i = 0; i + (1 << k) <= n; i++) {
                    int left = stMin[k - 1][i];
                    int right = stMin[k - 1][i + (1 << (k - 1))];
                    stMin[k][i] = (arr[left] <= arr[right]) ? left : right;

                    left = stMax[k - 1][i];
                    right = stMax[k - 1][i + (1 << (k - 1))];
                    stMax[k][i] = (arr[left] >= arr[right]) ? left : right;
                }
            }
        }

        int[] queryMin(int l, int r) {
            int j = logTable[r - l + 1];
            int left = stMin[j][l];
            int right = stMin[j][r - (1 << j) + 1];
            int idx = (arr[left] <= arr[right]) ? left : right;
            return new int[]{arr[idx], idx};
        }

        int[] queryMax(int l, int r) {
            int j = logTable[r - l + 1];
            int left = stMax[j][l];
            int right = stMax[j][r - (1 << j) + 1];
            int idx = (arr[left] >= arr[right]) ? left : right;
            return new int[]{arr[idx], idx};
        }
    }

    static class Segment implements Comparable<Segment> {
        int diff, l, r;
        Segment(int diff, int l, int r) {
            this.diff = diff;
            this.l = l;
            this.r = r;
        }

        public int compareTo(Segment o) {
            if (this.diff != o.diff) return Integer.compare(o.diff, this.diff); // max-heap behavior
            if (this.l != o.l) return Integer.compare(this.l, o.l);
            return Integer.compare(this.r, o.r);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable stt = new SparseTable(nums);

        TreeSet<Segment> ts = new TreeSet<>();
        int[] mnI = stt.queryMin(0, n - 1);
        int[] mxI = stt.queryMax(0, n - 1);
        ts.add(new Segment(mxI[0] - mnI[0], 0, n - 1));

        Map<String, Integer> seen = new HashMap<>();
        long ans = 0;

        while (!ts.isEmpty() && k > 0) {
            Segment seg = ts.pollFirst();
            int d = seg.diff;
            int l = seg.l, r = seg.r;

            String key = l + "," + r;
            if (seen.containsKey(key)) continue;
            seen.put(key, 1);

            mnI = stt.queryMin(l, r);
            mxI = stt.queryMax(l, r);

            int mxIdx = mxI[1];
            int mnIdx = mnI[1];

            long lrem = Math.min(mxIdx, mnIdx) - l + 1;
            long rrem = r - Math.max(mxIdx, mnIdx) + 1;
            long tot = lrem * rrem;

            if (tot >= k) {
                ans += (long) d * k;
                k = 0;
                break;
            }

            k -= tot;
            ans += (long) d * tot;

            if (l <= Math.max(mxIdx, mnIdx) - 1 && l >= 0 && Math.max(mxIdx, mnIdx) - 1 >= 0) {
                int newL = l, newR = Math.max(mxIdx, mnIdx) - 1;
                int[] mnSub = stt.queryMin(newL, newR);
                int[] mxSub = stt.queryMax(newL, newR);
                ts.add(new Segment(mxSub[0] - mnSub[0], newL, newR));
            }
            if (Math.min(mxIdx, mnIdx) + 1 <= r && r >= 0) {
                int newL = Math.min(mxIdx, mnIdx) + 1, newR = r;
                int[] mnSub = stt.queryMin(newL, newR);
                int[] mxSub = stt.queryMax(newL, newR);
                ts.add(new Segment(mxSub[0] - mnSub[0], newL, newR));
            }
        }

        return ans;
    }
}
