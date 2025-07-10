// Last updated: 7/10/2025, 8:49:19 AM
class Solution {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && (Math.floorMod(sb.charAt(len - 1) - c, 26) == 1 || Math.floorMod(c - sb.charAt(len - 1), 26) == 1)) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}