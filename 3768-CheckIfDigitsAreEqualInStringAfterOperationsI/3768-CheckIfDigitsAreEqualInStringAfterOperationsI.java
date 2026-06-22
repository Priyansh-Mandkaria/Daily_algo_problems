// Last updated: 6/22/2026, 1:36:50 PM
class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() != 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int x = ((s.charAt(i) - 'a') + (s.charAt(i - 1) - 'a')) % 10;
                sb.append((char)(x + 'a'));
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}