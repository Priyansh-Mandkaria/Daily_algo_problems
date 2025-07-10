// Last updated: 7/10/2025, 8:55:42 AM
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int half = n / 2;       
        for (int i = 0; i < half; i++) {
            result[i] = i + 1;
            result[n - 1 - i] = -(i + 1);
        }
        if (n % 2 != 0) {
            result[half] = 0;
        }
        return result;
    }
}