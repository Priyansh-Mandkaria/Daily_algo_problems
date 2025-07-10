// Last updated: 7/10/2025, 8:54:45 AM
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            return calculateMaxPoints(s, 'b', 'a', y, x);
        } else {
            return calculateMaxPoints(s, 'a', 'b', x, y);
        }
    }
    
    private static int calculateMaxPoints(String s, char first, char second, int firstPoints, int secondPoints) {
        int maxPoints = 0;
        StringBuilder sb = new StringBuilder();
        
        // First pass: remove the higher point substring
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == first && c == second) {
                sb.deleteCharAt(sb.length() - 1);
                maxPoints += firstPoints;
            } else {
                sb.append(c);
            }
        }
        
        // Second pass: remove the lower point substring
        s = sb.toString();
        sb.setLength(0);
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == second && c == first) {
                sb.deleteCharAt(sb.length() - 1);
                maxPoints += secondPoints;
            } else {
                sb.append(c);
            }
        }
        
        return maxPoints;   
    }
}
