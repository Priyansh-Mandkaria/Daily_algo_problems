// Last updated: 7/10/2025, 8:55:17 AM
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = i; j < n; j++) {
                a ^= arr[j];
                int b = 0;
                for (int k = j + 1; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}
