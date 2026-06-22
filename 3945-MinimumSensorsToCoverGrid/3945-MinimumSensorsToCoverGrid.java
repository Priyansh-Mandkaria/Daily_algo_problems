// Last updated: 6/22/2026, 1:35:29 PM
class Solution {
    public int minSensors(int n, int m, int k) {
        return ((n + 2*k)/(2*k + 1)) * ((m + 2*k)/(2*k +1));
    }
}