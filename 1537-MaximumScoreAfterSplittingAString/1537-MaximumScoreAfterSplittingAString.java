// Last updated: 7/10/2025, 8:55:19 AM
class Solution {
    public int maxScore(String s) {
        int totalOnes = 0; // Total count of '1's in the string
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }
        return maxScore;
    }
}