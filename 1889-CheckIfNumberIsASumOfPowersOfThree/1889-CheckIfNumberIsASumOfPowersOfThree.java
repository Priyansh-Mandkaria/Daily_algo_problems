// Last updated: 7/10/2025, 8:54:34 AM
class Solution {
    public boolean checkPowersOfThree(int n) {
        String s = Integer.toString(n, 3);
        return !s.contains("2");
    }
}