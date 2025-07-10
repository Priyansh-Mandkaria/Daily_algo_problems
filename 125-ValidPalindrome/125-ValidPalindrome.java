// Last updated: 7/10/2025, 8:58:43 AM
class Solution {
    public boolean isPalindrome(String s) {
       String s2 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return check(0, s2);
    }
    public static boolean check(int i, String s) {
        if (i >= s.length() / 2) return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return check(i + 1, s);
    }
}