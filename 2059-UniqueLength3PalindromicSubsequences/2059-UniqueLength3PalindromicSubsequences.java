// Last updated: 7/10/2025, 8:54:08 AM
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] left = new int[n][26]; 
        int[][] right = new int[n][26];
        int result = 0;
        for (int i = 1; i < n; i++) {
            System.arraycopy(left[i - 1], 0, left[i], 0, 26);
            left[i][s.charAt(i - 1) - 'a']++;
        }
        for (int i = n - 2; i >= 0; i--) {
            System.arraycopy(right[i + 1], 0, right[i], 0, 26);
            right[i][s.charAt(i + 1) - 'a']++;
        }
        boolean[][] seen = new boolean[26][26];
        for (int j = 1; j < n - 1; j++) {
            int middleChar = s.charAt(j) - 'a';
            for (int ch = 0; ch < 26; ch++) {
                if (left[j][ch] > 0 && right[j][ch] > 0 && !seen[ch][middleChar]) {
                    result++;
                    seen[ch][middleChar] = true; 
                }
            }
        }
        return result;
    }
}