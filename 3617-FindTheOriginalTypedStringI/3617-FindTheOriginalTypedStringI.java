// Last updated: 7/10/2025, 8:50:30 AM
class Solution {
    public int possibleStringCount(String word) {
        int total = 1; 
        int i = 0;
        int n = word.length();
        while (i < n) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int len = j - i;
            if (len >= 2) {
                total += (len - 1); 
            }
            i = j;
        }
        return total;
    }
}