// Last updated: 7/10/2025, 8:51:16 AM
class Solution {
    public int scoreOfString(String s) {
        int Sum_Of_Individual_Score = 0;
        for (int i = 1; i < s.length(); i++) {
            Sum_Of_Individual_Score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return Sum_Of_Individual_Score;
    }
}