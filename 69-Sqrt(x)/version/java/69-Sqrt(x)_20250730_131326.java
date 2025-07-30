// Last updated: 7/30/2025, 1:13:26 PM
class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) return mid;
            if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}