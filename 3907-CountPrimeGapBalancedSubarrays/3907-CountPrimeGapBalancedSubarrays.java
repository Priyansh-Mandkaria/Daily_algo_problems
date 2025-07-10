// Last updated: 7/10/2025, 8:49:08 AM
class Solution {
    public int primeSubarray(int[] nums, int k) {
        boolean[] prime = getPrimes(50001);
        return countValid(nums, k, prime);
    }
    private int countValid(int[] a, int k, boolean[] prime) {
        int n = a.length, l = 0, res = 0;
        int p1 = -1, p2 = -1;
        TreeMap<Integer, Integer> win = new TreeMap<>();

        for (int r = 0; r < n; r++) {
            int x = a[r];
            if (prime[x]) {
                win.put(x, win.getOrDefault(x, 0) + 1);
                p2 = p1;
                p1 = r;
            }
            l = shrink(a, l, win, k, prime);
            if (p2 != -1) {
                res += Math.max(0, p2 - l + 1);
            }
        }
        return res;
    }
    private int shrink(int[] a, int l, TreeMap<Integer, Integer> win, int k, boolean[] prime) {
        while (!win.isEmpty() && win.lastKey() - win.firstKey() > k) {
            int x = a[l];
            if (prime[x]) {
                int f = win.get(x);
                if (f == 1) win.remove(x);
                else win.put(x, f - 1);
            }
            l++;
        }
        return l;
    }
    private boolean[] getPrimes(int n) {
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);
        p[0] = p[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (p[i]) {
                for (int j = i * i; j < n; j += i) {
                    p[j] = false;
                }
            }
        }
        return p;
    }
}