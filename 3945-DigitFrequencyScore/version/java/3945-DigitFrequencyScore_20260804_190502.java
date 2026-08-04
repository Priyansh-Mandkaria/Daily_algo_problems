// Last updated: 8/4/2026, 7:05:02 PM
1class Solution {
2    public int digitFrequencyScore(int n) {
3        int totalScore = 0;
4        while (n > 0) {
5            totalScore += n % 10; 
6            n /= 10;              
7        }
8        return totalScore;
9    }
10}