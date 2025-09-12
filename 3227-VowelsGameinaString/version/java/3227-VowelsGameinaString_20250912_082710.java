// Last updated: 9/12/2025, 8:27:10 AM
class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++)
            if ("aeiou".indexOf(s.charAt(i)) != -1)
                return true;
        return false;
    }
}