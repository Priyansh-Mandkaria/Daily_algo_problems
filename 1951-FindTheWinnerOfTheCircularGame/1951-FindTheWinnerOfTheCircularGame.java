// Last updated: 7/10/2025, 8:54:25 AM
class Solution {
    public int findTheWinner(int n, int k) {
        return findWinnerPosition(n, k) + 1;
    }

    private static int findWinnerPosition(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            return (findWinnerPosition(n - 1, k) + k) % n;
        }
    }
}