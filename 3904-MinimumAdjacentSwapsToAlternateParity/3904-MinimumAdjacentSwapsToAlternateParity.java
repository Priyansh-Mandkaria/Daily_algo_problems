// Last updated: 7/10/2025, 8:49:11 AM
class Solution {
    public int minSwaps(int[] arr) {
         int even = 0, odd = 0;
        for (int val : arr) {
            if (val % 2 == 0) even++;
            else odd++;
        }
        if (Math.abs(even - odd) > 1) return -1;
        int res = Integer.MAX_VALUE;
        if (even >= odd) res = Math.min(res, cS(arr, 0));
        if (odd >= even) res = Math.min(res, cS(arr, 1));
        return res;
    }
    private int cS(int[] arr, int p) {
        int a = 0, swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == p) {
                swaps += Math.abs(i - a);
                a += 2;
            }
        }
        return swaps;
    }
}