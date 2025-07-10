// Last updated: 7/10/2025, 8:52:07 AM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
         int n = derived.length;
        boolean validCase1 = checkValidity(derived, 0);
        boolean validCase2 = checkValidity(derived, 1);
        return validCase1 || validCase2;
    }
    private boolean checkValidity(int[] derived, int start) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start;
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}