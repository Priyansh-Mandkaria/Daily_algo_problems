// Last updated: 7/10/2025, 8:53:04 AM
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] netShifts = new int[n];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            if (direction == 1) {
                netShifts[start] += 1;
                if (end + 1 < n) {
                    netShifts[end + 1] -= 1;
                }
            } else {
                netShifts[start] -= 1;
                if (end + 1 < n) {
                    netShifts[end + 1] += 1;
                }
            }
        }
        int cumulativeShift = 0;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            cumulativeShift += netShifts[i];
            int originalChar = s.charAt(i) - 'a';
            int shiftedChar = (originalChar + cumulativeShift) % 26;
            if (shiftedChar < 0) {
                shiftedChar += 26; 
            }
            result[i] = (char) ('a' + shiftedChar);
        }
        return new String(result);
    }
}