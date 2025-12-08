// Last updated: 12/8/2025, 10:15:27 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        return low%2 == 0 && high%2 == 0 ? (high-low)/2 : ((high-low)/2)+1;
4    }
5}